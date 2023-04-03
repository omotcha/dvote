package org.omotcha.services.impl;

import com.google.gson.Gson;
import org.omotcha.entities.Block;
import org.omotcha.services.BlockInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.http.HttpService;

@Service
public class BlockInfoServiceImpl implements BlockInfoService {

    private Web3j web3j;

    @Value("${web3j.client-address}")
    private String url;

    // omotcha: a fake member: use cache-db like redis instead
    private Block blockCache;

    @Override
    public String getBlockOverallJson(Long blockNum) throws Exception {
        // todo: if in cache, read from cache
        web3j = Web3j.build(new HttpService("http://"+url));
        DefaultBlockParameterNumber defaultBlockParameterNumber = new DefaultBlockParameterNumber(blockNum);
        EthBlock ethBlock = web3j.ethGetBlockByNumber(defaultBlockParameterNumber,true).sendAsync().get();
        EthBlock.Block block = ethBlock.getBlock();
        Gson gson = new Gson();
        return gson.toJson(block);
    }

    @Override
    public Block getBlockOverall(Long blockNum) throws Exception {
        // todo: if in cache, read from cache
        web3j = Web3j.build(new HttpService("http://"+url));
        DefaultBlockParameterNumber defaultBlockParameterNumber = new DefaultBlockParameterNumber(blockNum);
        EthBlock ethBlock = web3j.ethGetBlockByNumber(defaultBlockParameterNumber,true).sendAsync().get();
        EthBlock.Block block = ethBlock.getBlock();
        // create a Block object
        Block ret = new Block();
        ret.setHash(block.getHash());
        ret.setSize(block.getSize());
        ret.setTime(block.getTimestamp());
        ret.setHeight(block.getNumber());
        ret.setTxNum(block.getTransactions().size());
        return ret;
    }
}
