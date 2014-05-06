package com.wavemaker.restinvoker.utils;

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
}
