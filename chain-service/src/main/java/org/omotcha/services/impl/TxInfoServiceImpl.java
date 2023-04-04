package org.omotcha.services.impl;

import com.google.gson.Gson;
import org.omotcha.services.TxInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TxInfoServiceImpl implements TxInfoService {

    private Web3j web3j;


    @Value("${web3j.client-address}")
    private String url;

    // omotcha: a fake member: use cache-db like redis instead
    private Transaction transaction;

    @Override
    public String getTxJsonByBlockNum(Long blockNum) throws Exception {
        web3j = Web3j.build(new HttpService("http://"+url));
        DefaultBlockParameterNumber defaultBlockParameterNumber = new DefaultBlockParameterNumber(blockNum);
        EthBlock ethBlock = web3j.ethGetBlockByNumber(defaultBlockParameterNumber,true).sendAsync().get();
        List<EthBlock.TransactionResult> transactionResults = ethBlock.getBlock().getTransactions();
        List<Transaction> txInfos = new ArrayList<>();
        transactionResults.forEach(txInfo->{
            Transaction transaction = (Transaction)txInfo;
            txInfos.add(transaction);
        });
        Gson gson = new Gson();
        return gson.toJson(txInfos);
    }

    @Override
    public List<org.omotcha.entities.Transaction> getTxListByBlockNum(Long blockNum) throws Exception {
        web3j = Web3j.build(new HttpService("http://"+url));
        DefaultBlockParameterNumber defaultBlockParameterNumber = new DefaultBlockParameterNumber(blockNum);
        EthBlock ethBlock = web3j.ethGetBlockByNumber(defaultBlockParameterNumber,true).sendAsync().get();
        List<EthBlock.TransactionResult> transactionResults = ethBlock.getBlock().getTransactions();
        Transaction _tx;
        List<org.omotcha.entities.Transaction> ret = new ArrayList<>();
        for(EthBlock.TransactionResult txInfo:transactionResults){
            if(txInfo instanceof Transaction){
                _tx = (Transaction) txInfo.get();

                org.omotcha.entities.Transaction r = new org.omotcha.entities.Transaction();
                r.setHeight(_tx.getBlockNumber());
//                r.setChainID(BigInteger.valueOf(_tx.getChainId()));
                r.setHash(_tx.getHash());
                r.setTo(_tx.getTo());
                r.setFrom(_tx.getFrom());
                r.setRaw(_tx.getRaw());
                ret.add(r);
            }
        }
        return ret;
    }

    @Override
    public String getTxJsonByTxHash(String txHash) throws Exception {
        web3j = Web3j.build(new HttpService("http://"+url));
        EthTransaction transaction = web3j.ethGetTransactionByHash(txHash).sendAsync().get();
        Optional<Transaction> optionalTransaction = transaction.getTransaction();
        StringBuilder txInfo = new StringBuilder();
        if(optionalTransaction.isPresent()){
            Transaction transactionInfo = optionalTransaction.get();
            Gson gson = new Gson();
            txInfo.append(gson.toJson(transactionInfo));
        }
        return txInfo.toString();
    }

    @Override
    public org.omotcha.entities.Transaction getTxByTxHash(String txHash) throws Exception {
        web3j = Web3j.build(new HttpService("http://"+url));
        EthTransaction transaction = web3j.ethGetTransactionByHash(txHash).sendAsync().get();
        Optional<Transaction> optionalTransaction = transaction.getTransaction();
        org.omotcha.entities.Transaction ret = new org.omotcha.entities.Transaction();
        if(optionalTransaction.isPresent()){
            Transaction _tx = optionalTransaction.get();
            ret.setHeight(_tx.getBlockNumber());
//            ret.setChainID(BigInteger.valueOf(_tx.getChainId()));
            ret.setHash(_tx.getHash());
            ret.setTo(_tx.getTo());
            ret.setFrom(_tx.getFrom());
            ret.setRaw(_tx.getRaw());
        }
        return ret;
    }
}
