package com.wavemaker.restinvoker.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author Dilip Kumar.
 * @since 6/5/14
 */
public class PathUtils {
    public static String updatePathWithQueryParams(String path, Map<String, String> params) {
        String queryParamsString = "";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!queryParamsString.isEmpty()) {
                queryParamsString += "&";
            }
            try {
                queryParamsString += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // ignore.. this won't happen.
            }
        }
        return path + "?" + queryParamsString;
    }

    public static String updatePathWithPathParams(String path, Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String regex = "{" + entry.getKey() + "}";
            path = path.replaceAll(regex, entry.getValue());
        }
        return path;
    }

}
