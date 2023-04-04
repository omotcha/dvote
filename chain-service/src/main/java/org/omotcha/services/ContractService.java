package org.omotcha.services;

import org.omotcha.jcontracts.Vote;
import org.omotcha.model.req.DeployReq;
import org.omotcha.model.resp.ChainResultResp;

public interface ContractService {
    ChainResultResp deploy();

    Vote load(String addr);

}
