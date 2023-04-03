package org.omotcha.model.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChainResultResp {
    @ApiModelProperty("transaction hash")
    private String txHash;

    @ApiModelProperty("whether succeeded")
    private Boolean success;

    @ApiModelProperty("error message")
    private String err;

    @ApiModelProperty("normal return")
    private String result;

}
