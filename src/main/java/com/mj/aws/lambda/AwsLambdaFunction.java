package com.mj.aws.lambda;

import com.mj.aws.lambda.api.AnotherLambdaFunctionAPI;
import com.mj.aws.lambda.domain.PayloadRequest;
import com.mj.aws.lambda.domain.PayloadResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component("awsLambdaFunction")
public class AwsLambdaFunction implements Function<PayloadRequest,PayloadResponse> {

    @Autowired
    private AnotherLambdaFunctionAPI anotherLambdaFunctionAPI;

    @Override
    public PayloadResponse apply(PayloadRequest payloadRequest) {

        // Implement your logic here.

        // Invoke another lambda function
        PayloadResponse response =  anotherLambdaFunctionAPI.triggerAnotherLambdaFunction(payloadRequest);

        log.info("Retrieved response from another lambda: {}",response.toString());

        return response;
    }

}
