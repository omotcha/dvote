package org.omotcha.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omotcha.entities.Chain;
import org.omotcha.services.ChainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;

@RestController
@RequestMapping("/chaininfo")
@Api(tags="chain test")
public class ChainInfoController {

    @Autowired
    private ChainInfoService chainInfoService;

    private Chain chain;

    @GetMapping("/latestblocknum")
    @ApiOperation("get latest block num")
    public BigInteger getLatestBlockNum() throws Exception{
        return chainInfoService.getLatestBlockNum();
    }

    @GetMapping("/overall")
    @ApiOperation("get overall chain info")
    public Chain getChainOverall() throws Exception{
        return chainInfoService.getChainOverall();
    }


}
