package org.omotcha.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Transaction {
    private Long height;        //block height
    private Long blockID;       //block id
    private String hash;        //tx hash
    private Date time;          //tx time
    private String from;        //tx addr: from
    private String to;          //tx addr: to
    private String data;        //tx data

}
