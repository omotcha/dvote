package org.omotcha.entities;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class Chain {
    private BigInteger latestBlockNum;            //block count
    private List<String> accounts;          //accounts
    private BigInteger gasPrice;            //gas price
    private BigInteger chainID;             //chain id
    private String coinBase;                //coin base

}
