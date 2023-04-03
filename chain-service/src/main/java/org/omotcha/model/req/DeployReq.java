package org.omotcha.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.web3j.crypto.Credentials;

import java.math.BigInteger;

@Data
public class DeployReq {
    @ApiModelProperty("account credentials")
    private Credentials CREDENTIALS;
    private BigInteger GAS_PRICE;
    private BigInteger GAS_LIMIT;
    private String COIN_NAME;
    private String SYMBOL;
    private Long COIN_TOTAL;

}
