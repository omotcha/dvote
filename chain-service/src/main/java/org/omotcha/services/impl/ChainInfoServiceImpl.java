package org.omotcha.services.impl;

import org.omotcha.services.ChainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

@Service
public class ChainInfoServiceImpl implements ChainInfoService {

    private Web3j web3j;

    @Value("${web3j.client-address}")
    private String url;


    @Override
    public BigInteger getLatestBlockNum() throws Exception{
        web3j = Web3j.build(new HttpService("http://"+url));
        EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        BigInteger blockNumber = ethBlockNumber.getBlockNumber();
        return blockNumber;
    }
}
