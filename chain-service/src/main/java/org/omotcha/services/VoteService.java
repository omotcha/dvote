package org.omotcha.services;


import java.math.BigInteger;

public interface VoteService {
    String[] getCandidates(String addr);

    BigInteger getVote(String addr, String candidate);

    Boolean setVote(String addr, String candidate);

}
