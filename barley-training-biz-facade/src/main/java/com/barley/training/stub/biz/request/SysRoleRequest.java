package com.barley.training.stub.biz.request;

import lombok.Data;

import java.util.List;

@Data
public class SysRoleRequest {
    private Long id;
    private String name;
    private String description;
    private List<String> permissions;
}
