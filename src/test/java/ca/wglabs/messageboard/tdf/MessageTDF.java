package ca.wglabs.messageboard.tdf;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.model.Message;

import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Message createMessageResponse(String text, Long userId, Long originalMessageId) {
        Message message = createMessage(text, userId);
        message.setOriginalMessageId(originalMessageId);
        return message;
    }

    public static List<Message> createMessage(List<String> messages) {
        return messages.stream()
                .map(MessageTDF::createMessage)
                .collect(Collectors.toList());
    }

    public static MessageDto createMessageDto(String text) {
        return createMessageDto(text, null);
    }

    public static MessageDto createMessageResponseDto(String text, Long userId, Long originalMessageId) {
        MessageDto messageDto = createMessageDto(text, userId);
        messageDto.setOriginalMessageId(originalMessageId);
        return messageDto;
    }

    public static MessageDto createMessageDto(String text, Long userId) {
        MessageDto messageDto =  new MessageDto();
        messageDto.setCreateDate(Date.from(Instant.now()));
        messageDto.setUserId(userId);
        messageDto.setText(text);
        return messageDto;
    }

    public static List<MessageDto> createMessageDto(List<String> messages) {
        return messages.stream()
                .map(MessageTDF::createMessageDto)
                .collect(Collectors.toList());
    }
}
