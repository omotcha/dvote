package org.omotcha.entities;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Transaction {
    private BigInteger height;      //block height
    private BigInteger chainID;     //chain id
    private String hash;            //tx hash
    private String from;            //tx addr: from
    private String to;              //tx addr: to
    private String raw;         //tx payload

}
