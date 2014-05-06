package com.wavemaker.restinvoker.invoker;

/**
 * @author Dilip Kumar.
 * @since 6/5/14
 */
public class CallerArguments {
    private final String path;
    private final String responseType;
    private final String contentType;
    private final Arguments arguments;

    public CallerArguments(String path, String contentType, String responseType, Arguments arguments) {
        this.path = path;
        this.responseType = responseType;
        this.contentType = contentType;
        this.arguments = arguments;
    }

    public String getPath() {
        return path;
    }

    public String getResponseType() {
        return responseType;
    }

    public String getContentType() {
        return contentType;
    }

    public Arguments getArguments() {
        return arguments;
    }
}
