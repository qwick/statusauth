package com.shenlan.springboot.controller;

import com.shenlan.springboot.annotation.RequiresPermission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/admin")
//    @RequiresPermission("ADMIN")
    public String adminEndpoint() {
        return "Welcome to the admin area!";
    }

}

