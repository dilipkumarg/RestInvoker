package com.wavemaker.restinvoker.invoker;

import com.wavemaker.restinvoker.models.MetaModel;
import com.wavemaker.restinvoker.models.MetaOperationModel;
import com.wavemaker.restinvoker.models.RuntimeRequestModel;
import com.wavemaker.restinvoker.utils.PathUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dilip Kumar.
 * @since 5/5/14
 */
public class Caller {
    private static final Map<String, HttpMethod> methodMap = new HashMap<String, HttpMethod>();

    static {
        methodMap.put("get", HttpMethod.GET);
        methodMap.put("post", HttpMethod.POST);
        methodMap.put("put", HttpMethod.PUT);
        methodMap.put("delete", HttpMethod.DELETE);
    }


    public Caller() {

    }

    public String call(MetaModel metaModel, RuntimeRequestModel requestModel) {
        MetaOperationModel operation = metaModel.getOperation();
        if (operation != null) {
            Arguments args = new ArgumentsBuilder(operation, requestModel.getParameters()).build();
            // TODO validate all required fields are there?
            CallerArguments callerArguments = buildCallerArguments(metaModel.getPath(),
                    requestModel.getContentType(), requestModel.getAcceptType(),
                    args);

            HttpMethod method = methodMap.get(operation.getHttpMethod().toLowerCase());
            return method.doRequest(callerArguments);
        }
        throw new IllegalArgumentException("Operation should not be null");
    }

    private CallerArguments buildCallerArguments(String basePath, String contentType, String responseType,
                                                 Arguments args) {
        String path = buildRequestPath(basePath, args);
        return new CallerArguments(path, contentType, responseType, args);
    }

    private String buildRequestPath(final String basePath, final Arguments arguments) {
        String path = basePath;
        path = PathUtils.updatePathWithQueryParams(path, arguments.getQueryArgs());
        return path;
    }

}
