package com.zss.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) {
        log.info("测试log");

        for (int i = 0; i < 10; i++) {
            log.error("something wrong. id={}; name=Ryan-{};", i, i);
        }
    }
}
