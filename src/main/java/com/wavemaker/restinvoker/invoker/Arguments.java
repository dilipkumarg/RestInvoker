package com.wavemaker.restinvoker.invoker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dilip Kumar.
 * @since 6/5/14
 */
public class Arguments {
    private Map<String, String> pathArgs;
    private Map<String, String> queryArgs;
    private Map<String, String> formArgs;
    private String bodyArg;

    public Arguments() {
        pathArgs = new HashMap<String, String>();
        queryArgs = new HashMap<String, String>();
        formArgs = new HashMap<String, String>();
        bodyArg = null;
    }

    public Arguments(Map<String, String> pathArgs, Map<String, String> formArgs, Map<String, String> queryArgs,
                     String bodyArg) {
        this.pathArgs = pathArgs;
        this.queryArgs = queryArgs;
        this.bodyArg = bodyArg;
        this.formArgs = formArgs;
    }

    public Map<String, String> getFormArgs() {
        return formArgs;
    }

    public void setFormArgs(Map<String, String> formArgs) {
        this.formArgs = formArgs;
    }

    public Map<String, String> getPathArgs() {
        return pathArgs;
    }

    public void setPathArgs(Map<String, String> pathArgs) {
        this.pathArgs = pathArgs;
    }

    public Map<String, String> getQueryArgs() {
        return queryArgs;
    }

    public void setQueryArgs(Map<String, String> queryArgs) {
        this.queryArgs = queryArgs;
    }

    public String getBodyArg() {
        return bodyArg;
    }

    public void setBodyArg(String bodyArg) {
        this.bodyArg = bodyArg;
    }
}
