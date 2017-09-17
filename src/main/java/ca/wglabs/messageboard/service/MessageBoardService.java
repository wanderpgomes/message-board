package ca.wglabs.messageboard.service;


import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.model.Message;
import ca.wglabs.messageboard.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class MessageBoardService {


    @Autowired
    private MessageRepository messageRepository;

    public MessageDto createMessage(MessageDto messageDto){

        messageDto.setCreateDate(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime());
        Optional<Message> message = Optional.of(messageDto).map(MessageConverter::toEntity);

        messageRepository.save(message.get());

        return message.map(MessageConverter::toDto).get();
    }
}
