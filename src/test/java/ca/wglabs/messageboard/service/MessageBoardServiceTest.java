package ca.wglabs.messageboard.service;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.model.Message;
import ca.wglabs.messageboard.repository.MessageRepository;
import ca.wglabs.messageboard.tdf.MessageTDF;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageBoardServiceTest {

    @Mock
    private MessageRepository messageRepository;


    @InjectMocks
    private MessageBoardService fixture;


    @Test
    public void testCreateMessage() {
        MessageDto messageDto = MessageTDF.createMessageDto("Hi!");

        fixture.createMessage(messageDto);

        verify(messageRepository).save(any(Message.class));
    }

    @Test
    public void testGetMessages() {
        List<Message> messages = MessageTDF.createMessage(Arrays.asList("Hello!", "Hi there!"));

        when(messageRepository.findAllByOrderByIdAsc()).thenReturn(messages);

        List<MessageDto> actual = fixture.getMessages();

        assertEquals("Hello!", actual.get(0).getText());
        assertEquals("Hi there!", actual.get(1).getText());
    }

}
