package org.omotcha.controllers;

import io.swagger.annotations.Api;
import org.omotcha.jcontracts.Vote;
import org.omotcha.model.resp.ChainResultResp;
import org.omotcha.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
@Api(tags = "contract test")
public class ContractController {
    @Autowired
    private ContractService contractService;

    /**
     * Deploy the contract.
     * This demo only deploy Vote.java in jcontracts
     * @return
     */

    @GetMapping("/deploy")
    public ChainResultResp deploy(){
        return contractService.deploy();
    }

    @GetMapping("/load")
    public Vote load(String addr){
        return contractService.load(addr);
    }
}
