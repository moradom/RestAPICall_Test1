/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.restapicalltest.variablejavaservice.controller;

import com.restapicalltest.variablejavaservice.VariableJavaService;
import java.lang.Boolean;
import javax.servlet.http.HttpServletRequest;
import pt.credirisk.ruleengine.client.model.Variable;
import java.util.List;
import pt.credirisk.ruleengine.client.model.VariableDataCreation;
import pt.credirisk.ruleengine.client.model.VariableDataCreationResult;
import java.lang.String;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/variableJava")
public class VariableJavaController {

    @Autowired
    private VariableJavaService variableJavaService;

    @RequestMapping(value = "/variables", method = RequestMethod.GET)
    public List<Variable> listVariables(@RequestParam(value = "enabled", required = false) Boolean enabled, HttpServletRequest request) {
        return variableJavaService.listVariables(enabled, request);
    }

    @RequestMapping(value = "/postVariable", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public VariableDataCreationResult postVariable(@RequestBody VariableDataCreation var, HttpServletRequest request) {
        return variableJavaService.postVariable(var, request);
    }

    @RequestMapping(value = "/sampleJavaOperation", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public String sampleJavaOperation(@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
        return variableJavaService.sampleJavaOperation(name, request);
    }
}
