package com.wavemaker.restinvoker.models;

import java.util.List;

/**
 * @author Dilip Kumar.
 * @since 5/5/14
 */
public class MetaOperationModel {
    private String httpMethod;
    private String methodName;
    private List<String> produces;
    private List<String> consumes;
    private List<MetaParameterModel> parameters;

    public MetaOperationModel(String httpMethod, String methodName, List<String> produces, List<String> consumes,
                              List<MetaParameterModel> parameters) {
        this.httpMethod = httpMethod;
        this.methodName = methodName;
        this.produces = produces;
        this.consumes = consumes;
        this.parameters = parameters;
    }

    public MetaOperationModel() {

    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<String> getProduces() {
        return produces;
    }

    public void setProduces(List<String> produces) {
        this.produces = produces;
    }

    public List<String> getConsumes() {
        return consumes;
    }

    public void setConsumes(List<String> consumes) {
        this.consumes = consumes;
    }

    public List<MetaParameterModel> getParameters() {
        return parameters;
    }

    public void setParameters(List<MetaParameterModel> parameters) {
        this.parameters = parameters;
    }
}
