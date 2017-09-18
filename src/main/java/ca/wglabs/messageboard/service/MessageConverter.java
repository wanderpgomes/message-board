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

        ZonedDateTime zdt = ZonedDateTime.of(messageDto.getCreateDate(), ZoneOffset.UTC);
        Calendar calendar = GregorianCalendar.from(zdt);
        message.setCreateDate(calendar);

        return message;
    }

    public static MessageDto toDto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(Objects.toString(message.getId(), ""));
        LocalDateTime ldt = LocalDateTime.ofInstant(message.getCreateDate().toInstant(), ZoneId.systemDefault());
        messageDto.setCreateDate(ldt);
        messageDto.setText(message.getText());

        return messageDto;
    }
}
