package org.omotcha.services.impl;

import org.omotcha.jcontracts.Vote;
import org.omotcha.model.req.DeployReq;
import org.omotcha.model.resp.ChainResultResp;
import org.omotcha.services.ContractService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public ChainResultResp deploy(DeployReq req) {
        return null;
    }

    @Override
    public ChainResultResp load(String addr) {
        return null;
    }

    @Override
    public ChainResultResp invoke(String addr, String method) {
        return null;
    }

    @Override
    public DeployReq getDeployReq() {
        web3j = Web3j.build(new HttpService("http://"+url));
        Vote vote;

        DeployReq req = new DeployReq();
        req.setCOIN_NAME("eth");
        req.setGAS_PRICE(Vote.GAS_PRICE);
        req.setSYMBOL("eth");
        req.setCREDENTIALS(credentials);


        return req;
    }
}
