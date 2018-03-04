package com.test.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Qualifier("counterService")
    @Autowired
    private CounterService counterService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        counterService.increment("test.hello.count");

        return counterService.toString();
    }


}
