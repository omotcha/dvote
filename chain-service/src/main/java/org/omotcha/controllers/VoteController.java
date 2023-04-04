package org.omotcha.controllers;

import io.swagger.annotations.Api;
import org.omotcha.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
@Api(tags = "vote test")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @GetMapping("/candidates")
    public String[] getCandidates(String addr){
        return voteService.getCandidates(addr);
    }
}
