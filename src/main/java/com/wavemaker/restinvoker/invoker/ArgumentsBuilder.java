package com.wavemaker.restinvoker.invoker;

import com.wavemaker.restinvoker.models.MetaOperationModel;
import com.wavemaker.restinvoker.models.MetaParameterModel;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @author Dilip Kumar.
 * @since 6/5/14
 */
public class ArgumentsBuilder {
    private final MetaOperationModel operation;
    private final Map<String, String> runtimeParameters;

    public ArgumentsBuilder(MetaOperationModel operation, Map<String, String> runtimeParameters) {
        Assert.notNull(operation);
        Assert.notNull(runtimeParameters);
        this.operation = operation;
        this.runtimeParameters = runtimeParameters;
    }

    public Arguments build() {
        Arguments args = new Arguments();

        for (Map.Entry<String, String> parameter : runtimeParameters.entrySet()) {
            MetaParameterModel metaParameterModel = getParameterInOperation(operation.getParameters(),
                    parameter.getKey());
            if (metaParameterModel != null) {
                if (metaParameterModel.getParamType().equals("path")) {
                    args.getPathArgs().put(parameter.getKey(), parameter.getValue());
                } else if (metaParameterModel.getParamType().equals("query")) {
                    args.getQueryArgs().put(parameter.getKey(), parameter.getValue());
                } else if (metaParameterModel.getParamType().equals("body")) {
                    args.setBodyArg(parameter.getValue());
                } else if (metaParameterModel.getParamType().equals("form")) {
                    args.getFormArgs().put(parameter.getKey(), parameter.getValue());
                } else {
                    throw new IllegalArgumentException("Parameter type should be predefined type");
                }
            }
        }

        return args;
    }

    private MetaParameterModel getParameterInOperation(List<MetaParameterModel> metaParameterModels, String paramName) {
        for (MetaParameterModel model : metaParameterModels) {
            if (model.getName() != null && model.getName().equals(paramName)) {
                return model;
            }
        }
        return null;
    }
}
