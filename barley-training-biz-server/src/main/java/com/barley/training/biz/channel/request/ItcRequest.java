package com.barley.training.biz.channel.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItcRequest<T> {
    private String company;
    private String device_name;
    private T data;
}
