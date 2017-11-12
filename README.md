# aws-lambda
A sample Java AWS Lambda function to trigger another Lambda function using AWS SDK.

# Guide
- Replace the other function name in com.mj.aws.lambda.api.AnotherLambdaFunctionAPI with your desired AWS Lambda function name.
- Build the project using: mvn clean install
- Create and configure using the aws lambda requirement below.
- Upload the jar file with suffix "-aws" to AWS lambda.
- Update the handler field with: com.mj.aws.lambda.AwsLambdaFunctionHandler
- Create test payload as below and test the event. 
-- {"message": "message"}

# AWS Lambda Requirements:
- 256 MB of Memory. (Can try with lower one)
- Timeout 1 min.
- Execution role
-- Access to Lambda Function Policy
-- Access to Cloud watch for logging Policy


# Libraries
- Spring Cloud Function: https://spring.io/blog/2017/07/05/introducing-spring-cloud-function
- AWS Java SDK
- Lombok
- Log4j
- Jackson Object Mapper
- Maven

# Credits
Based on https://dzone.com/articles/run-code-with-spring-cloud-function-on-aws-lambda
