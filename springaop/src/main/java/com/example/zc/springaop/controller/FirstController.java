package com.example.zc.springaop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @RequestMapping("/first")
    public Object first() {
        return "first controller";
    }

    @RequestMapping("/first02")
    public Object first02() {
        return "first02 controller";
    }

    @RequestMapping("/doError")
    public Object error() {
        return 1 / 0;
    }
}