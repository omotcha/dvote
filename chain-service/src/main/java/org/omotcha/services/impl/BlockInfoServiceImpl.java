package org.omotcha.services.impl;

import org.omotcha.entities.Block;
import org.omotcha.services.BlockInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;

@Service
public class BlockInfoServiceImpl implements BlockInfoService {

    private Web3j web3j;

    @Value("${web3j.client-address}")
    private String url;

    // todo omotcha: a fake member: use cache-db like redis instead
    private Block blockCache;

    @Override
    public String getBlockOverallJson(Long blockNum) throws Exception {
        // todo: if in cache, read from cache

        return null;
    }

    @Override
    public Block getBlockOverall(Long blockNum) throws Exception {
        return null;
    }
}
