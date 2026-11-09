package com.idealtrain.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.Map;

public class HelloHandler implements
        RequestHandler<APIGatewayProxyRequestEvent,
                       APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(
            APIGatewayProxyRequestEvent event,
            Context context) {

        context.getLogger().log("Received API Gateway request");

        String responseBody = """
                {
                    "message": "Hello from Java 21 AWS Lambda!",
                    "service": "hello-lambda",
                    "status": "SUCCESS"
                }
                """;

        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withHeaders(Map.of(
                        "Content-Type", "application/json"
                ))
                .withBody(responseBody)
                .withIsBase64Encoded(false);
    }
}