package com.barley.training.biz.channel.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InspectRequest {

    private String app_code = "00000000000000000000000000000000";

    private String role_id = "2";

    private String inspection_type = "0";

}
