package com.mj.aws.lambda.api;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.amazonaws.services.lambda.invoke.LambdaFunctionNameResolver;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactoryConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Component
public class CustomLambdaFunctionNameResolver implements LambdaFunctionNameResolver {

    private Environment env;

    @Autowired
    public CustomLambdaFunctionNameResolver(Environment env) {
        this.env = env;
    }

    @Override
    public String getFunctionName(Method method, LambdaFunction lambdaFunction, LambdaInvokerFactoryConfig lambdaInvokerFactoryConfig) {
        String functionName = this.getFunctionNameFromPropertyFile(lambdaFunction.functionName());
        if(functionName.isEmpty()){
            functionName = method.getName();
        }
        return functionName;
    }

    public String getFunctionNameFromPropertyFile(String functionName){
        try{
            if(functionName.isEmpty()){
                return "";
            }
            return env.getProperty(functionName,"");
        }catch (Exception e){
            log.error("Unable to extract function: {} from env.",functionName);
            return "";
        }

    }

}
