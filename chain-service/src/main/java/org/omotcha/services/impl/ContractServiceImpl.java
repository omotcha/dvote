package org.omotcha.services.impl;

import org.omotcha.jcontracts.Vote;
import org.omotcha.model.resp.ChainResultResp;
import org.omotcha.services.ContractService;
import org.omotcha.utils.Bytes32Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    private Web3j web3j;
    
    private final static Credentials credentials;

    static {
        Path path = Paths.get("keystore/0x38ba98381F0f409e5A8aaB472975b5216f715037");
        String content;
        try {
            content = Files.readAllLines(path).get(0);
        } catch (IOException e) {
            content = "";
        }
        credentials = Credentials.create(content);
    }

    @Value("${web3j.client-address}")
    private String url;

    @Override
    public ChainResultResp deploy() {
        ChainResultResp resp = new ChainResultResp();
        Vote contract = null;
        try{
            web3j = Web3j.build(new HttpService("http://"+url));
            BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
            ContractGasProvider provider = new DefaultGasProvider(){
                @Override
                public BigInteger getGasPrice(String contractFunc){
                    return gasPrice;
                }

                @Override
                public BigInteger getGasLimit(String contractFunc){
                    return BigInteger.valueOf(1000000);
                }
            };
            List<byte[]> params = new ArrayList<>();
            Bytes32Util bytes32Util = new Bytes32Util();
            params.add(bytes32Util.str2bytes32("4100000000000000000000000000000000000000000000000000000000000000"));
            params.add(bytes32Util.str2bytes32("4200000000000000000000000000000000000000000000000000000000000000"));
            contract = Vote.deploy(web3j, credentials, provider, params).sendAsync().get();
        }catch (Exception e){
            resp.setSuccess(false);
            resp.setErr(e.getMessage());
        }
        if(contract!=null){
            resp.setSuccess(true);
            resp.setResult(contract.getContractAddress());
            // how to set the transaction hash for the response?
        }else {
            resp.setSuccess(false);
            resp.setErr("error deploying the contract");
        }
        return resp;
    }

    @Override
    public Vote load(String addr) {
        try{
            web3j = Web3j.build(new HttpService("http://"+url));
            BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
            ContractGasProvider provider = new DefaultGasProvider(){
                @Override
                public BigInteger getGasPrice(String contractFunc){
                    return gasPrice;
                }

                @Override
                public BigInteger getGasLimit(String contractFunc){
                    return BigInteger.valueOf(1000000);
                }
            };
            return Vote.load(addr,web3j,credentials,provider);
        }catch (Exception e){
            return null;
        }
    }

}
