package ca.wglabs.messageboard.rest.controller;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.dto.UserDto;
import ca.wglabs.messageboard.service.MessageBoardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://localhost:9000")
@Api(value="message-board-controller", description="Operations pertaining to messages on the Message Board Application")
public class MessageBoardRestController {


    @Autowired
    private MessageBoardService messageBoardService;

    @PostMapping("/messages")
    public MessageDto addMessage(@RequestBody MessageDto message){
        return messageBoardService.createMessage(message);
    }

    @GetMapping("/messages")
    public List<MessageDto> getMessages(@RequestParam(required = false) Long userId) {
        return messageBoardService.getMessages(userId);
    }

    @GetMapping("/responses")
    public List<MessageDto> getResponses(@RequestParam Long originalMessageId) {
        return messageBoardService.getResponses(originalMessageId);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return messageBoardService.getUsers();
    }

    @GetMapping("/ping")
    public String ping(){
        return "Ping: " + new Date();
    }


}
