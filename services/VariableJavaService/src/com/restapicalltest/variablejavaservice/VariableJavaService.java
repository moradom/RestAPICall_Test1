/*Copyright (c) 2017-2018 preito.com All Rights Reserved.
 This software is the confidential and proprietary information of preito.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with preito.com*/
package com.restapicalltest.variablejavaservice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

import pt.credirisk.ruleengine.client.api.VariableApi;
import pt.credirisk.ruleengine.client.model.Variable;
import pt.credirisk.ruleengine.client.model.VariableDataCreation;
import pt.credirisk.ruleengine.client.model.VariableDataCreation.TypeEnum;
import pt.credirisk.ruleengine.client.model.VariableDataCreation.SourceEnum;
import pt.credirisk.ruleengine.client.model.VariableDataCreationResult;

import java.util.List;
import java.util.ArrayList;

//import com.restapicalltest.variablejavaservice.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 *
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 *
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 */
@ExposeToClient
public class VariableJavaService {

    private static final Logger logger = LoggerFactory.getLogger(VariableJavaService.class);

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private VariableApi variableApi;


    /**
     * This is sample java operation that accepts an input from the caller and responds with "Hello".
     *
     * SecurityService that is Autowired will provide access to the security context of the caller. It has methods like isAuthenticated(),
     * getUserName() and getUserId() etc which returns the information based on the caller context.
     *
     * Methods in this class can declare HttpServletRequest, HttpServletResponse as input parameters to access the
     * caller's request/response objects respectively. These parameters will be injected when request is made (during API invocation).
     */
    public String sampleJavaOperation(String name, HttpServletRequest request) {
        logger.debug("Starting sample operation with request url " + request.getRequestURL().toString());
        
        String result = null;
        if (securityService.isAuthenticated()) {
            result = "Hello " + name + ", You are logged in as "+  securityService.getLoggedInUser().getUserName();
        } else {
            result = "Hello " + name + ", You are not authenticated yet!";
        }
        logger.debug("Returning {}", result);
        return result;
    }

    public List<Variable> listVariables(Boolean enabled, HttpServletRequest request) {
        logger.debug("Starting sample operation with request url " + request.getRequestURL().toString());
         
        return variableApi.listVariables(enabled);
    }
    
    public VariableDataCreationResult postVariable(VariableDataCreation var, HttpServletRequest request) {
        logger.debug("Starting sample operation with request url " + request.getRequestURL().toString());
        //VariableDataCreation var = new VariableDataCreation();
        var.setUsername(securityService.getLoggedInUser().getUserName());
        var.setUid(securityService.getLoggedInUser().getUserId());
        return variableApi.createVariableData(var);
    }    
    
    public List<String> getVariableDataType() {
        // VariableDataCreation.TypeEnum MyEnum = VariableDataCreation.TypeEnum;
        //String a = TypeEnum.STRATEGY.toString();
        ArrayList<String> a = new ArrayList();
        for (TypeEnum t : TypeEnum.values()) {
            a.add(t.getValue());
        }
        return a;
        /*
        return  Stream.of(TypeEnum.values())
                               .map(TypeEnum::name)
                               .collect(Collectors.toList());
        */
    }
    
    public List<String> getVariableDataSource() {
      // VariableDataCreation.TypeEnum MyEnum = VariableDataCreation.TypeEnum;
      //String a = TypeEnum.STRATEGY.toString();
      ArrayList<String> a = new ArrayList();
      for (SourceEnum t : SourceEnum.values()) {
          a.add(t.getValue());
      }
      return a;
        /*
        return  Stream.of(TypeEnum.values())
                               .map(TypeEnum::name)
                               .collect(Collectors.toList());
        */
    }
    

}
