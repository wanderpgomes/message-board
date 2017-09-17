package ca.wglabs.messageboard.tdf;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.model.Message;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class MessageTDF {


    public static Message createMessage(String text) {
       return createMessage(text, null);
    }

    public static Message createMessage(String text, Long userId) {
        Message message =  new Message();
        message.setCreateDate(new GregorianCalendar());
        message.setUserId(userId);
        message.setText(text);
        return message;
    }

    public static MessageDto createMessageDto(String text) {
        MessageDto messageDto =  new MessageDto();
        messageDto.setCreateDate(LocalDateTime.now());
        messageDto.setText(text);
        return messageDto;
    }
}
