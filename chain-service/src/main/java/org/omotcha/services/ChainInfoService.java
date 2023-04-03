package org.omotcha.services;

import org.omotcha.entities.Chain;

import java.math.BigInteger;

public interface ChainInfoService {

    BigInteger getLatestBlockNum() throws Exception;

    Chain getChainOverall() throws Exception;


}
