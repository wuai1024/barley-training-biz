package com.barley.training.biz.channel.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItcBaseResponse {
    private int httpStatusCode;
    private String responseStr;

    private String company;
    @JsonProperty("device_name")
    private String deviceName;
    private int result;
    @JsonProperty("return_message")
    private String returnMessage;
}
