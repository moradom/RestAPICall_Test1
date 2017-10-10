/*Copyright (c) 2017-2018 preito.com All Rights Reserved.
 This software is the confidential and proprietary information of preito.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with preito.com*/
package com.restapicalltest.variablejavaservice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pt.credirisk.ruleengine.client.api.VariableApi;
import pt.credirisk.ruleengine.client.invoker.ApiClient;

@Configuration
public class VariableIntegrationConfig {

    @Bean
    public VariableApi variablepi() {
        return new VariableApi(apiClient());
    }
    
    @Bean
    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        return apiClient;
    }
    
}