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
        message.setUserId((messageDto.getUserId() != null) ? Long.valueOf(messageDto.getUserId()) : null);

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(messageDto.getCreateDate());
        message.setCreateDate(calendar);

        return message;
    }

    public static MessageDto toDto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(Objects.toString(message.getId(), ""));

        messageDto.setCreateDate(message.getCreateDate().getTime());
        messageDto.setText(message.getText());

        return messageDto;
    }
}
