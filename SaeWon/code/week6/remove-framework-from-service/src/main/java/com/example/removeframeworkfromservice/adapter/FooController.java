package com.example.removeframeworkfromservice.adapter;

import com.example.removeframeworkfromservice.application.FooService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    private final FooService service;

    public FooController(FooService service) {
        this.service = service;
    }

    @GetMapping("/test/{command}")
    public void foo(@PathVariable("command") String command){
        service.foo(command);
    }


}
