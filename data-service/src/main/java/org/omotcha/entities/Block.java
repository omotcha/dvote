package org.omotcha.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * Block contains fields in block-info that are important and needed to be stored in databases
 */
@Data
@TableName("block")
public class Block {
    @TableField("height")
    private BigInteger height;          //block height
    @TableField("createTime")
    private BigInteger time;            //block create time
    @TableField("hash")
    private String hash;                //block hash
    @TableField("blockSize")
    private BigInteger size;            //block size
    @TableField("txNum")
    private Integer txNum;              //number of tx

}
