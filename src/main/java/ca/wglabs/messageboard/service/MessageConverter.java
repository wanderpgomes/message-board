package ca.wglabs.messageboard.service;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.model.Message;

import java.util.Objects;

public class MessageConverter {

    public static Message toEntity(MessageDto messageDto){
        Message message = new Message();
        message.setText(messageDto.getText());
        return message;
    }

    public static MessageDto toDto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(Objects.toString(message.getId(), ""));
        messageDto.setText(message.getText());
        return messageDto;
    }
}
