package com.example.springbootlog.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class indexController {
    private static final Logger logger = getLogger(indexController.class);

    @GetMapping("/hello")
    public void hello() {
        logger.info("controller.indexController");
    }
}
