package org.omotcha.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Block {
    private Long height;        //block height
    private Date time;          //block create time
    private String hash;        //block hash
    private Long size;          //block size
    private Integer txNum;      //number fo tx

}
