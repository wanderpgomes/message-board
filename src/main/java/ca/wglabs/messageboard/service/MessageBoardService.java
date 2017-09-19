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
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageBoardService {


    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;


    public MessageDto createMessage(MessageDto messageDto){

        messageDto.setCreateDate(Date.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant()));
        Optional<Message> message = Optional.of(messageDto).map(MessageConverter::toEntity);

        messageRepository.save(message.get());

        return message.map(MessageConverter::toDto).get();
    }


    public List<MessageDto> getMessages() {
        return messageRepository.findAllByOrderByIdAsc().stream()
                .map(MessageConverter::toDto)
                .collect(Collectors.toList());
    }

    public List<MessageDto> getMessages(Long userId) {
        if (userId != null) {
            return messageRepository.findByUserId(userId).stream()
                    .map(MessageConverter::toDto)
                    .collect(Collectors.toList());
        } else return getMessages();
    }

    public List<UserDto> getUsers() {
        return userRepository.findAllByOrderByIdAsc().stream()
                .map(UserConverter::toDto)
                .collect(Collectors.toList());
    }
}
