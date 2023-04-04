package org.omotcha.services.impl;

import org.omotcha.jcontracts.Vote;
import org.omotcha.services.ContractService;
import org.omotcha.services.VoteService;
import org.omotcha.utils.Bytes32Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class VoteServiceImpl implements VoteService {

    private static final Bytes32Util bytes32Util = new Bytes32Util();
    @Autowired
    ContractService contractService;
    @Override
    public String[] getCandidates(String addr) {
        String[] strings = new String[2];
        try{
            Vote vote = contractService.load(addr);
            strings[0] = bytes32Util.bytes322str(vote.candidates(BigInteger.valueOf(0)).sendAsync().get());
            strings[1] = bytes32Util.bytes322str(vote.candidates(BigInteger.valueOf(1)).sendAsync().get());
        }catch (Exception e){
            return null;
        }
        return strings;
    }

    @Override
    public BigInteger getVote(String addr, String candidate) {
        try{
            byte[] bytes = bytes32Util.str2bytes32(candidate);
            Vote vote = contractService.load(addr);
            return vote.getVote(bytes).sendAsync().get();
        }catch (Exception e){
            return BigInteger.valueOf(0);
        }
    }

    @Override
    public Boolean setVote(String addr, String candidate) {
        try{
            byte[] bytes = bytes32Util.str2bytes32(candidate);
            Vote vote = contractService.load(addr);
            return vote.setVote(bytes).sendAsync().get().isStatusOK();
        }catch (Exception e){
            return false;
        }
    }
}
