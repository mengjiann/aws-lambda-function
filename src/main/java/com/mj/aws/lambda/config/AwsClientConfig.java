package com.mj.aws.lambda.config;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsyncClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import com.mj.aws.lambda.api.AnotherLambdaFunctionAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsClientConfig {

    @Bean
    public AnotherLambdaFunctionAPI anotherLambdaFunctionAPI(){
        return LambdaInvokerFactory.builder().
                lambdaClient(awsLambdaClient()).
                build(AnotherLambdaFunctionAPI.class);
    }

    private AWSLambda awsLambdaClient() {
        return AWSLambdaAsyncClientBuilder.defaultClient();
    }




}
