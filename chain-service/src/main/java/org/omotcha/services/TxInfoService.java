package org.omotcha.services;

import org.omotcha.entities.Transaction;

import java.util.List;

public interface TxInfoService {
    String getTxJsonByBlockNum(Long blockNum) throws Exception;

    List<org.omotcha.entities.Transaction> getTxListByBlockNum(Long blockNum) throws Exception;

    String getTxJsonByTxHash(String txHash) throws Exception;

    Transaction getTxByTxHash(String txHash) throws Exception;
}
