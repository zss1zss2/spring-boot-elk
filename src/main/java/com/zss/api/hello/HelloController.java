package com.zss.api.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @Autowired
    private HelloService helloService;

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello/{id}")
    public ResponseEntity getHello(@PathVariable String id) {
        Hello helloById = helloService.getHelloById(id);
        logger.info("this hello is {}", helloById);
        return ResponseEntity.ok(helloById);
    }
}
