package org.omotcha.entities;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigInteger;
import java.util.List;

@Data
@TableName("chain")
public class Chain {
    @TableField("latestBlockNum")
    private BigInteger latestBlockNum;      //block count
    @TableField("accounts")
    private String accounts;          //accounts
    @TableField("gasPrice")
    private BigInteger gasPrice;            //gas price
    @TableField("chainID")
    private BigInteger chainID;             //chain id
    @TableField("coinBase")
    private String coinBase;                //coin base

}
