package org.omotcha.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omotcha.entities.Block;
import org.omotcha.services.BlockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blockinfo")
@Api(tags = "block test")
public class BlockInfoController {
    @Autowired
    private BlockInfoService blockInfoService;

    @GetMapping("/overalljson")
    @ApiOperation("get overall block info in json")
    public String getBlockOverallJson(Long blockNum) throws Exception{
        return blockInfoService.getBlockOverallJson(blockNum);
    }

    @GetMapping("/overall")
    @ApiOperation("get overall block info in Block")
    public Block getBlockOverall(Long blockNum) throws Exception{
        return blockInfoService.getBlockOverall(blockNum);
    }

}
