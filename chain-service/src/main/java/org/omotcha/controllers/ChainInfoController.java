package org.omotcha.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omotcha.services.ChainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;

import javax.annotation.Resource;
import java.math.BigInteger;

@RestController
@RequestMapping("/chaininfo")
@Api(tags="chain test")
public class ChainInfoController {

    @Autowired
    private ChainInfoService chainInfoService;

    @Value("${web3j.client-address}")
    private static String url;

    @GetMapping("/latestblocknum")
    @ApiOperation("get latest block num")
    public BigInteger getLatestBlockNum() throws Exception{
        return chainInfoService.getLatestBlockNum();
    }
}
