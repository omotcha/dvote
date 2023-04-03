package org.omotcha.services.impl;

import org.omotcha.entities.Transaction;
import org.omotcha.services.TxInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TxInfoServiceImpl implements TxInfoService {
    @Override
    public String getTxJsonByBlockNum(Long blockNum) throws Exception {
        return null;
    }

    @Override
    public List<Transaction> getTxListByBlockNum(Long blockNum) throws Exception {
        return null;
    }

    @Override
    public String getTxJsonByTxHash(String txHash) throws Exception {
        return null;
    }

    @Override
    public Transaction getTxByTxHash(String txHash) throws Exception {
        return null;
    }
}
