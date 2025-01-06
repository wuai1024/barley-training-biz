package com.barley.training.biz.channel.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiveDeleteResponse extends ItcBaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
}
