package com.barley.training.stub.biz.request;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class SysUserRequest {
    private Long id;
    private String name;
    private String phone;
    private List<String> roles;
    private Boolean primary;
    private String remarks;

    public Boolean getPrimary() {
        return !Objects.isNull(primary) && primary;
    }
}
