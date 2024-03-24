package edu.sabanciuniv.main.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HelloComtroller {



@GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
