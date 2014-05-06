package com.wavemaker.restinvoker.models;

/**
 * @author Dilip Kumar.
 * @since 5/5/14
 */
public class MetaModel {
    private String path;
    private MetaOperationModel operation;

    public MetaModel(String path, MetaOperationModel operation) {
        this.path = path;
        this.operation = operation;
    }

    public MetaModel() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MetaOperationModel getOperation() {
        return operation;
    }

    public void setOperation(MetaOperationModel operation) {
        this.operation = operation;
    }
}
