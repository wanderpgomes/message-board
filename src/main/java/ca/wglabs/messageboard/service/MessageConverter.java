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
        message.setCity(messageDto.getCity());
        message.setTemperature(messageDto.getTemperature());
        message.setLatitude(messageDto.getLatitude());
        message.setLongitude(messageDto.getLongitude());

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
        messageDto.setCity(message.getCity());
        messageDto.setTemperature(message.getTemperature());
        messageDto.setLatitude(message.getLatitude());
        messageDto.setLongitude(message.getLongitude());
        messageDto.setText(message.getText());

        return messageDto;
    }
}
