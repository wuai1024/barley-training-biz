package com.barley.training.biz.channel.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessTokenResponse extends ItcBaseResponse {

    @JsonProperty("return")
    private int code;
    private String message;
    @JsonProperty("access_token")
    private String accessToken;
    private Long expires;

}
