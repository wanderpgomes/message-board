package ca.wglabs.messageboard.rest.controller;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.service.MessageBoardService;
import ca.wglabs.messageboard.service.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class MessageBoardRestController {


    @Autowired
    private MessageBoardService messageBoardService;

    @PostMapping("/messages")
    @CrossOrigin(origins = "http://localhost:9000")
    public MessageDto addMessage(@RequestBody MessageDto message){
        return messageBoardService.createMessage(message);
    }

    @GetMapping("/ping")
    public String ping(){
        return "Ping: " + new Date();
    }
}
