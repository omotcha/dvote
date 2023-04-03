package org.omotcha.services.impl;

import org.omotcha.model.req.DeployReq;
import org.omotcha.model.resp.ChainResultResp;
import org.omotcha.services.ContractService;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Override
    public ChainResultResp deploy(DeployReq req) {
        return null;
    }

    @Override
    public ChainResultResp load(String addr) {
        return null;
    }

    @Override
    public ChainResultResp invoke(String addr, String method) {
        return null;
    }
}
