package com.wavemaker.restinvoker.models;

/**
 * @author Dilip Kumar.
 * @since 5/5/14
 */
public class MetaParameterModel {
    private String name;
    private boolean required;
    private String paramType;

    public MetaParameterModel(String name, boolean required, String paramType) {
        this.name = name;
        this.required = required;
        this.paramType = paramType;
    }

    public MetaParameterModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }
}
