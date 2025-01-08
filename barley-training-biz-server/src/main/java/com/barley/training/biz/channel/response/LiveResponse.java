package com.barley.training.biz.channel.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiveResponse extends ItcBaseResponse {

    private String status;
    private int code;
    private String msg;
    private Data data;

    @Getter
    @Setter
    public static class Data {
        private Integer id;
    }

}
