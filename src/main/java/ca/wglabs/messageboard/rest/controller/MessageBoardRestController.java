package ca.wglabs.messageboard.rest.controller;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class MessageBoardRestController {


    @Autowired
    private MessageBoardService messageBoardService;

    @PostMapping("/messages")
    public MessageDto addMessage(@RequestBody MessageDto message){
        return messageBoardService.createMessage(message);
    }

    @GetMapping("/messages")
    public List<MessageDto> getAllMessages() {
        return messageBoardService.getMessages();
    }

    @GetMapping("/ping")
    public String ping(){
        return "Ping: " + new Date();
    }
}
