package com.wavemaker.restinvoker.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author Dilip Kumar.
 * @since 6/5/14
 */
public class Utils {
    public static final String DEFAULT_CONTENT_TYPE = "application/json";

    public static String defaultTypeOnInvalidType(String contentType) {
        if (contentType == null || contentType.isEmpty()) {
            return DEFAULT_CONTENT_TYPE;
        }
        // TODO validate content type?
        return contentType;
    }

    /**
     * Returns the updated path with query parameters.
     *
     * @param path
     * @param params
     * @return
     */
    public static String updatePathWithQueryParams(String path, Map<String, String> params) {
        String queryParamsString = "";
        String regex = ".*(\\?.*)";
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
        // checking if query params exists?
        char separator = (path.matches(regex)) ? '&' : '?';
        return path + separator + queryParamsString;
    }
}
