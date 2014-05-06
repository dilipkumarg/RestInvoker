package com.wavemaker.restinvoker.invoker;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Dilip Kumar.
 * @since 6/5/14
 */
public enum HttpMethod {
    GET {
        @Override
        String doRequest(CallerArguments callerArguments) {
            RestTemplate restTemplate = new RestTemplate();
            Map<String, String> formArgs = callerArguments.getArguments().getFormArgs();

            if (formArgs != null && !formArgs.isEmpty()) {
                // TODO add form parameters to url
            }

            return restTemplate.getForObject(callerArguments.getPath(), String.class,
                    callerArguments.getArguments().getPathArgs());
        }
    },
    POST {
        @Override
        String doRequest(CallerArguments cArgs) {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<?> httpEntity = buildHttpEntity(restTemplate, cArgs);
            return restTemplate.postForObject(cArgs.getPath(), httpEntity, String.class,
                    cArgs.getArguments().getPathArgs());
        }


    },
    PUT {
        @Override
        String doRequest(CallerArguments callerArguments) {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<?> httpEntity = buildHttpEntity(restTemplate, callerArguments);
            restTemplate.put(callerArguments.getPath(), httpEntity, callerArguments.getArguments().getPathArgs());
            // TODO send response?
            return "";
        }
    },
    DELETE {
        @Override
        String doRequest(CallerArguments callerArguments) {
            RestTemplate restTemplate = new RestTemplate();
            // TODO send response?
            restTemplate.delete(callerArguments.getPath(), callerArguments.getArguments().getPathArgs());
            return "";
        }
    };

    abstract String doRequest(CallerArguments callerArguments);

    private static HttpEntity<?> buildHttpEntity(RestTemplate restTemplate, CallerArguments cArgs) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(MediaType.parseMediaTypes(cArgs.getResponseType()));
        headers.setContentType(MediaType.parseMediaType(cArgs.getContentType()));

        // setting body params
        Arguments args = cArgs.getArguments();
        HttpEntity<?> httpEntity;
        if (args.getPathArgs() != null && !args.getFormArgs().isEmpty()) {
            // setting required headers configuration
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            configureRestTemplateForFormParams(restTemplate);
            MultiValueMap<String, String> map = buildFormArgs(args.getFormArgs());

            httpEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        } else if (args.getBodyArg() != null && !args.getBodyArg().isEmpty()) {
            httpEntity = new HttpEntity<String>(args.getBodyArg(), headers);
        } else {
            httpEntity = new HttpEntity<String>(headers);
        }
        return httpEntity;
    }

    private static void configureRestTemplateForFormParams(RestTemplate restTemplate) {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new FormHttpMessageConverter());
        restTemplate.setMessageConverters(converters);
    }

    private static MultiValueMap<String, String> buildFormArgs(Map<String, String> formArgs) {
        // building form arguments
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        for (Map.Entry<String, String> entry : formArgs.entrySet()) {
            // TODO support for multi value parameters.
            map.add(entry.getKey(), entry.getValue());
        }
        return map;
    }
}
