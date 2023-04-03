package org.omotcha.services;

import org.omotcha.entities.Block;

public interface BlockInfoService {
    String getBlockOverallJson(Long blockNum) throws Exception;

    Block getBlockOverall(Long blockNum) throws Exception;

}
