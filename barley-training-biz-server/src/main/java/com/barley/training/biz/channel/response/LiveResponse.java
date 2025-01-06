package com.barley.training.biz.channel.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiveResponse extends ItcBaseResponse {

    private DataContainer data;

    @Getter
    @Setter
    public static class DataContainer {
        private String status;
        private DeviceData data;
    }

    @Getter
    @Setter
    public static class DeviceData {
        private String id;
    }

}
