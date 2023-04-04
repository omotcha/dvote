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
    @Autowired
    ContractService contractService;
    @Override
    public String[] getCandidates(String addr) {
        String[] strings = new String[2];
        Bytes32Util bytes32Util = new Bytes32Util();
        try{
            Vote vote = contractService.load(addr);
            strings[0] = bytes32Util.bytes322str(vote.candidates(BigInteger.valueOf(0)).sendAsync().get());
            strings[1] = bytes32Util.bytes322str(vote.candidates(BigInteger.valueOf(1)).sendAsync().get());
        }catch (Exception e){
            e.printStackTrace();
        }
        return strings;
    }
}
