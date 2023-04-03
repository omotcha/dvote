package org.omotcha.services;

import org.omotcha.model.req.DeployReq;
import org.omotcha.model.resp.ChainResultResp;

public interface ContractService {
    ChainResultResp deploy();

    ChainResultResp load(String addr);

    ChainResultResp invoke(String addr, String method);

}
