package ca.wglabs.messageboard.service;

import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.model.Message;
import ca.wglabs.messageboard.repository.MessageRepository;
import ca.wglabs.messageboard.tdf.MessageTDF;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

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

        verify(messageRepository).save(Mockito.any(Message.class));
    }


}
