package org.omotcha.services.impl;

import org.omotcha.entities.Chain;
import org.omotcha.services.ChainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

@Service
public class ChainInfoServiceImpl implements ChainInfoService {

    private Web3j web3j;

    @Value("${web3j.client-address}")
    private String url;

    private Chain chainCache;


    @Override
    public BigInteger getLatestBlockNum() throws Exception{
        if(chainCache!=null){
            return chainCache.getLatestBlockNum();
        }
        web3j = Web3j.build(new HttpService("http://"+url));
        EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        return ethBlockNumber.getBlockNumber();
    }

    @Override
    public Chain getChainOverall() throws Exception {
        web3j = Web3j.build(new HttpService("http://"+url));
        Chain ret = new Chain();
        // set latest block num
        EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        ret.setLatestBlockNum(ethBlockNumber.getBlockNumber());
        // set accounts
        EthAccounts ethAccounts = web3j.ethAccounts().sendAsync().get();
        ret.setAccounts(ethAccounts.getAccounts());
        // set gas price
        EthGasPrice ethGasPrice = web3j.ethGasPrice().sendAsync().get();
        ret.setGasPrice(ethGasPrice.getGasPrice());
        // set chain id
        EthChainId ethChainId = web3j.ethChainId().sendAsync().get();
        ret.setChainID(ethChainId.getChainId());
        // set coin base
        EthCoinbase ethCoinbase = web3j.ethCoinbase().sendAsync().get();
        ret.setCoinBase(ethCoinbase.getAddress());
        // sync local
        chainCache = ret;
        return ret;
    }
}
