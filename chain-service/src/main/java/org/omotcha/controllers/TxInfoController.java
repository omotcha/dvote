package org.omotcha.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omotcha.entities.Transaction;
import org.omotcha.services.TxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/txinfo")
@Api(tags = "transaction info")
public class TxInfoController {
    @Autowired
    private TxInfoService txInfoService;
    @GetMapping("/jsonnumber")
    @ApiOperation("get transactions in json by block num")
    public String getTxJsonByBlockNum(Long blockNum) throws Exception{
        return txInfoService.getTxJsonByBlockNum(blockNum);
    }

    @GetMapping("/listnumber")
    @ApiOperation("get transactions list by block num")
    public List<Transaction> getTxListByBlockNum(Long blockNum) throws Exception{
        return txInfoService.getTxListByBlockNum(blockNum);
    }

    @GetMapping("/jsonhash")
    @ApiOperation("get transaction in json by transaction hash")
    public String getTxJsonByTxHash(String txHash) throws Exception{
        return txInfoService.getTxJsonByTxHash(txHash);
    }
    @GetMapping("/txhash")
    @ApiOperation("get transaction by transaction hash")
    public Transaction getTxByTxHash(String txHash) throws Exception{
        return txInfoService.getTxByTxHash(txHash);
    }
}
