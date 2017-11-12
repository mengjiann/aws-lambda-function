package com.mj.aws.lambda.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class PayloadResponse {

    public PayloadResponse(String message) {
        this.message = message;
    }

    private String message;

}
