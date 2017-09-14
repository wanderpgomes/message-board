package ca.wglabs.messageboard.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MessageBoardRestController {

    @GetMapping("/echo")
    public String echo(@RequestParam String msg){
        return msg;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Ping: " + new Date();
    }
}
