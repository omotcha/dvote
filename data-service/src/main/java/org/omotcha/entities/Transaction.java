package org.omotcha.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigInteger;


@Data
@TableName("tx")
public class Transaction {
    @TableField("height")
    private BigInteger height;      //block height
//    @TableField("chainID")
//    private BigInteger chainID;     //chain id
    @TableField("hash")
    private String hash;            //tx hash
    @TableField("fromAddr")
    private String from;            //tx addr: from
    @TableField("toAddr")
    private String to;              //tx addr: to
    @TableField("raw")
    private String raw;         //tx payload

}
