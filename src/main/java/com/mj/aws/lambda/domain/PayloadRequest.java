package com.mj.aws.lambda.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class PayloadRequest {

    private String message;

    public PayloadRequest(String message) {
        this.message = message;
    }
}
