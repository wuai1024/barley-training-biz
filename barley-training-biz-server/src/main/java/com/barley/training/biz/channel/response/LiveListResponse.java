package com.barley.training.biz.channel.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class LiveListResponse extends ItcBaseResponse {

    private Map<String, Object> data;

}
