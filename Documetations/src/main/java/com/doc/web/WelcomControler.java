package com.doc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WelcomControler {

    @GetMapping
    private String welcome()
    {
        return "Hello";
    }
}
