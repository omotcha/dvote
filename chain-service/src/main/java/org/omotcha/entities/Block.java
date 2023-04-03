package org.omotcha.entities;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * Block contains fields in block-info that are important and needed to be stored in databases
 */
@Data
public class Block {
    private BigInteger height;        //block height
    private BigInteger time;          //block create time
    private String hash;        //block hash
    private BigInteger size;          //block size
    private Integer txNum;      //number fo tx

}
