package com.cosmos.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/readExcelDataFallBack")
    public String readExcelDataFallBackMethod() {
        return "Read Excel Service is taking longer than Expected." +
                " Please try again later";
    }
    @GetMapping("/notesFallBack")
    public String notesFallBack() {
        return "Note Service is taking longer than Expected." +
                " Please try again later";
    }
    @GetMapping("/updatecompanyFallBack")
    public String updatecompanyFallBack() {
        return "Update Company Service is taking longer than Expected." +
                " Please try again later";
    }
    @GetMapping("/shareFallBack")
    public String shareFallBack() {
        return "Update Share Service is taking longer than Expected." +
                " Please try again later";
    }
    @GetMapping("/adminFallBack")
    public String adminFallBack() {
        return "Admin Service is taking longer than Expected." +
                " Please try again later";
    }
}
