package org.omotcha.controllers;

import io.swagger.annotations.Api;
import org.omotcha.services.MigrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/migrate")
@Api(tags = "migrate test")
public class MigrateController {
    @Autowired
    private MigrateService migrateService;

    @PostMapping("/chain")
    public boolean migrateChain(){
        return migrateService.migrateChain();
    }

    @PutMapping("/block")
    public boolean migrateBlock(){
        return migrateService.migrateBlock();
    }
}
