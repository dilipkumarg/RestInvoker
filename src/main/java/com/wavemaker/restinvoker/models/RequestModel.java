package com.wavemaker.restinvoker.models;

/**
 * @author Dilip Kumar.
 * @since 5/5/14
 */
public class RequestModel {
    private MetaModel metaModel;
    private RuntimeRequestModel requestModel;

    public RequestModel(MetaModel metaModel, RuntimeRequestModel requestModel) {
        this.metaModel = metaModel;
        this.requestModel = requestModel;
    }

    public RequestModel() {
    }

    public MetaModel getMetaModel() {
        return metaModel;
    }

    public void setMetaModel(MetaModel metaModel) {
        this.metaModel = metaModel;
    }

    public RuntimeRequestModel getRequestModel() {
        return requestModel;
    }

    public void setRequestModel(RuntimeRequestModel requestModel) {
        this.requestModel = requestModel;
    }
}
