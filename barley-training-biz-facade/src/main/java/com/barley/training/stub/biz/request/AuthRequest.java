package com.barley.training.stub.biz.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String account;
    private String password;
}
