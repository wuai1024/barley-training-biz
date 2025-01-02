package com.barley.training.stub.biz.bean.admin;

import lombok.Data;

import java.util.List;

@Data
public class MenusDTO {
    private String parentCode;
    private String code;
    private String path;
    private String name;
    private String icon;
    private Integer sort;
    private List<MenusDTO> children;

    public String getKey() {
        return code;
    }
}

