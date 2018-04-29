package com.mj.aws.lambda.config;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import com.mj.aws.lambda.api.AnotherLambdaFunctionAPI;
import com.mj.aws.lambda.api.CustomLambdaFunctionNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsLambdaFunctionApiConfig {

    private AWSLambda awsLambda;

    private CustomLambdaFunctionNameResolver functionNameResolver;

    @Autowired
    public AwsLambdaFunctionApiConfig(AWSLambda awsLambda, CustomLambdaFunctionNameResolver functionNameResolver) {
        this.awsLambda = awsLambda;
        this.functionNameResolver = functionNameResolver;
    }

    @Bean
    public AnotherLambdaFunctionAPI anotherLambdaFunctionAPI(){
        return LambdaInvokerFactory.builder()
                .lambdaClient(awsLambda)
                .lambdaFunctionNameResolver(functionNameResolver)
                .build(AnotherLambdaFunctionAPI.class);
    }

}
