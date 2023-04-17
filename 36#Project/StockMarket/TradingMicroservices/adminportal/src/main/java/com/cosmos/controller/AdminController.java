package com.cosmos.controller;

import com.cosmos.document.Wallet;
import com.cosmos.service.AdminService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //@PostMapping("/addcash")
    @RequestMapping(value = "/addcash",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Wallet addCash(@RequestBody Wallet wallet){
        return adminService.addCash(wallet);
    }
    @PostMapping("/withdrawcash")
    public Wallet withdrawCash(@RequestBody Wallet wallet){
        return adminService.withdrawCash(wallet);
    }
}
