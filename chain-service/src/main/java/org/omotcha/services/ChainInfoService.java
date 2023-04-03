package org.omotcha.services;

import org.omotcha.entities.Chain;

import java.math.BigInteger;

public interface ChainInfoService {

    public BigInteger getLatestBlockNum() throws Exception;

    public Chain getChainOverall() throws Exception;


}
