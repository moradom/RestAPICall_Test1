/*Copyright (c) 2017-2018 preito.com All Rights Reserved.
 This software is the confidential and proprietary information of preito.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with preito.com*/
package com.restapicalltest.rule_engine_dev_v1.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;
import com.wordnik.swagger.annotations.Api;

import com.restapicalltest.rule_engine_dev_v1.service.Rule_engine_dev_v1ProcedureExecutorService;

@RestController(value = "Rule_engine_dev_v1.ProcedureExecutionController")
@RequestMapping("/rule_engine_dev_v1/procedureExecutor")
@Api(value = "ProcedureExecutionController", description = "controller class for procedure execution")
public class ProcedureExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureExecutionController.class);

    @Autowired
    private Rule_engine_dev_v1ProcedureExecutorService procedureService;


}

