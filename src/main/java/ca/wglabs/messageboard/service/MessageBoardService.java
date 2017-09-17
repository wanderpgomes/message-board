package ca.wglabs.messageboard.service;


import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.dto.UserDto;
import ca.wglabs.messageboard.model.Message;
import ca.wglabs.messageboard.repository.MessageRepository;
import ca.wglabs.messageboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MessageBoardService {


    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;


    public MessageDto createMessage(MessageDto messageDto){

        messageDto.setCreateDate(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime());
        Optional<Message> message = Optional.of(messageDto).map(MessageConverter::toEntity);

        messageRepository.save(message.get());

        return message.map(MessageConverter::toDto).get();
    }


    public List<MessageDto> getMessages() {

        Iterable<Message> messages = messageRepository.findAllByOrderByIdAsc();

        return StreamSupport.stream(messages.spliterator(), false)
                .map(MessageConverter::toDto)
                .collect(Collectors.toList());
    }


    public List<UserDto> getUsers() {
        return userRepository.findAllByOrderByIdAsc().stream()
                .map(UserConverter::toDto)
                .collect(Collectors.toList());
    }
}
