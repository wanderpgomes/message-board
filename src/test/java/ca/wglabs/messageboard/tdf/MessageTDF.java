package ca.wglabs.messageboard.tdf;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.model.Message;

public class MessageTDF {


    public static Message createMessage(String text) {
        Message message =  new Message();
        message.setText(text);
        return message;
    }

    public static MessageDto createMessageDto(String text) {
        MessageDto messageDto =  new MessageDto();
        messageDto.setText(text);
        return messageDto;
    }
}
