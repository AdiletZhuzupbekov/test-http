package com.megacom.testhttp.controllers;

import com.megacom.testhttp.models.Album;
import com.megacom.testhttp.models.Geo;
import com.megacom.testhttp.services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {
    private final AccountService accountService;

    public AlbumController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/test")
    public List<Album> test(){
        return  accountService.test();
    }

}
