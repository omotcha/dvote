package org.omotcha.services;

import org.omotcha.entities.Block;
import org.omotcha.entities.Transaction;

import java.util.List;

public interface BlockInfoService {
    String getBlockOverallJson(Long blockNum) throws Exception;

    Block getBlockOverall(Long blockNum) throws Exception;

}
