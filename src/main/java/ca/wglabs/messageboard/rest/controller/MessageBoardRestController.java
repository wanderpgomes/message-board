package ca.wglabs.messageboard.rest.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class MessageBoardRestController {



    @PostMapping("/messages")
    @CrossOrigin(origins = "http://localhost:9000")
    public String addMessage(@RequestBody String msg){
        return msg;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Ping: " + new Date();
    }
}
