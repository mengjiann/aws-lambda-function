package com.mj.aws.lambda.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsyncClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import com.mj.aws.lambda.AwsLambdaFunction;
import com.mj.aws.lambda.api.AnotherLambdaFunctionAPI;
import com.mj.aws.lambda.api.CustomLambdaFunctionNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AwsClientConfig {

    @Bean
    @Profile("local")
    public AWSLambda awsLambdaClientLocal() {
        return AWSLambdaAsyncClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localstack:4574","eu-west-1"))
                .build();

    }

    @Bean
    @Profile("aws")
    public AWSLambda awsLambdaClientAws() {
        return AWSLambdaAsyncClientBuilder.defaultClient();
    }

}
