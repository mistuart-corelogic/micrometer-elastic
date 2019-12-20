package com.example.micrometerelastic;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @RequestMapping
    @Timed(histogram = true)
    public String hello() {
        try {
            Thread.sleep((int) ((Math.random() * (4)) + 0) * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        log.info("Hello called");
        return "Hello";
    }
}
