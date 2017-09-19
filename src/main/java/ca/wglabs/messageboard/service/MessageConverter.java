package ca.wglabs.messageboard.service;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.model.Message;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class MessageConverter {

    public static Message toEntity(MessageDto messageDto){
        Message message = new Message();
        message.setText(messageDto.getText());
        message.setUserId(messageDto.getUserId());
        message.setOriginalMessageId(messageDto.getOriginalMessageId());

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(messageDto.getCreateDate());
        message.setCreateDate(calendar);

        return message;
    }

    public static MessageDto toDto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setUserId(message.getUserId());
        messageDto.setOriginalMessageId(message.getOriginalMessageId());
        messageDto.setCreateDate(message.getCreateDate().getTime());
        messageDto.setText(message.getText());

        return messageDto;
    }
}
