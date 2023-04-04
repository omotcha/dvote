package org.omotcha.services.impl;

import org.omotcha.entities.Chain;
import org.omotcha.mappers.IChainMapper;
import org.omotcha.services.ChainInfoService;
import org.omotcha.services.MigrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MigrateServiceImpl implements MigrateService {

    @Autowired
    private ChainInfoService chainInfoService;

    @Autowired
    private IChainMapper iChainMapper;
    @Override
    public boolean migrateChain() {
        try{
            Chain chainInfo = chainInfoService.getChainOverall();
            iChainMapper.insert(chainInfo);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
