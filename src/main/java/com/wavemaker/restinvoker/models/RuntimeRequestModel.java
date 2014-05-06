package com.wavemaker.restinvoker.models;

import com.wavemaker.restinvoker.utils.Utils;

import java.util.Map;

/**
 * @author Dilip Kumar.
 * @since 5/5/14
 */
public class RuntimeRequestModel {
    private String requestMethod;
    private String acceptType;
    private String contentType;
    private Map<String, String> parameters;

    public RuntimeRequestModel(String acceptType, String requestMethod, Map<String, String> parameters) {
        this.acceptType = acceptType;
        this.requestMethod = requestMethod;
        this.parameters = parameters;
    }

    public RuntimeRequestModel() {
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getAcceptType() {
        return Utils.defaultTypeOnInvalidType(acceptType);
    }

    public void setAcceptType(String acceptType) {
        this.acceptType = acceptType;
    }

    public String getContentType() {
        return Utils.defaultTypeOnInvalidType(contentType);
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
