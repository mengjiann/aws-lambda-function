package com.mj.aws.lambda;

import com.mj.aws.lambda.domain.PayloadRequest;
import com.mj.aws.lambda.domain.PayloadResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class AwsLambdaFunctionHandler extends SpringBootRequestHandler<PayloadRequest,PayloadResponse>{
}
