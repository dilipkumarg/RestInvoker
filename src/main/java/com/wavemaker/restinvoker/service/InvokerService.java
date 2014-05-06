package com.wavemaker.restinvoker.service;

import com.wavemaker.restinvoker.invoker.Caller;
import com.wavemaker.restinvoker.models.MetaModel;
import com.wavemaker.restinvoker.models.RequestModel;
import com.wavemaker.restinvoker.models.RuntimeRequestModel;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Dilip Kumar.
 * @since 5/5/14
 */
@Service
public class InvokerService {
    public String invoke(MetaModel metaModel, RuntimeRequestModel requestModel) {
        return new Caller().call(metaModel, requestModel);
    }

    public String invoke(RequestModel requestModel) {
        return invoke(requestModel.getMetaModel(), requestModel.getRequestModel());
    }
}
