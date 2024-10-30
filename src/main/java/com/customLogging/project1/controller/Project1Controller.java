package com.customLogging.project1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Project1Controller {

    @GetMapping("/test")
    public String testMethod(){
        log.info("Info Log saved in Info File of Packaged");

        log.error("Error log saved in Error file of packaged");
        return "Tested Succesfully";
    }
}
