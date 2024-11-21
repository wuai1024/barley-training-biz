package com.barley.training.biz.constant;

import com.barley.common.base.exception.ResponseCodeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UscResponseCode implements ResponseCodeException {


    ERROR("%s"),
    ERROR_10001("参数缺失"),
    ERROR_10002("参数错误"),
    SERVICE_ERROR("系统异常");

    private final String message;

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getModule() {
        return "billbear-supply-chain";
    }

}
