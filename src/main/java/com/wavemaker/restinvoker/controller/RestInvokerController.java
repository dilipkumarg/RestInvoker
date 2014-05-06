package com.wavemaker.restinvoker.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wavemaker.restinvoker.service.InvokerService;
import com.wavemaker.restinvoker.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dilip Kumar.
 * @since 5/5/14
 */
@Controller
@RequestMapping("/invoke")
public class RestInvokerController {

    @Autowired
    private InvokerService invokerService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    String invoke() {
        RequestModel requestModel = new RequestModel();
        requestModel.setMetaModel(dummyMetaModel());
        requestModel.setRequestModel(dummyRequestModel());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(requestModel);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    String invoke(@RequestBody RequestModel requestModel) {
        return invokerService.invoke(requestModel);
    }

    private MetaModel dummyMetaModel() {
        MetaModel metaModel = new MetaModel();

        MetaOperationModel operation = new MetaOperationModel();
        operation.setHttpMethod("GET");
        operation.setMethodName("testMethod");

        List<MetaParameterModel> parameters = new ArrayList<MetaParameterModel>();
        parameters.add(new MetaParameterModel("orderId", true, "path"));
        operation.setParameters(parameters);

        metaModel.setPath("http://petstore.swagger.wordnik.com/api/store/order/{orderId}");
        metaModel.setOperation(operation);
        return metaModel;
    }

    private RuntimeRequestModel dummyRequestModel() {
        RuntimeRequestModel requestModel = new RuntimeRequestModel();

        requestModel.setRequestMethod("testMethod");
        requestModel.setAcceptType("application/json");

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("orderId", "2");

        requestModel.setParameters(parameters);

        return requestModel;
    }
}
