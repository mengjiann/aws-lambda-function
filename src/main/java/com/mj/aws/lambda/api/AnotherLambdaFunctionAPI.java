package com.mj.aws.lambda.api;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.mj.aws.lambda.domain.PayloadRequest;
import com.mj.aws.lambda.domain.PayloadResponse;

public interface AnotherLambdaFunctionAPI {

    @LambdaFunction(functionName = "another.function.name")
    PayloadResponse triggerAnotherLambdaFunction(PayloadRequest resizeRequest);

}
