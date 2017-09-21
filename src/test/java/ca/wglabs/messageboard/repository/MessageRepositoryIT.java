package ca.wglabs.messageboard.repository;

import ca.wglabs.messageboard.config.DataSourceConfiguration;
import ca.wglabs.messageboard.config.PersistenceConfiguration;
import ca.wglabs.messageboard.model.Message;
import ca.wglabs.messageboard.tdf.MessageTDF;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfiguration.class, PersistenceConfiguration.class})
public class MessageRepositoryIT {

    @Autowired
    protected MessageRepository messageRepository;

    private static final String TEST_MESSAGE = "test message";
    private static final Long USER_ID = 1L;


    @Test
    public void testSaveMessage() {
        Message message = MessageTDF.createMessage(TEST_MESSAGE, USER_ID, "Toronto", 20.1d, 43.7d, -79.42d);

        Message result = messageRepository.save(message);

        assertNotNull(result.getId());
        assertEquals(message.getText(), result.getText());
    }

    @Test
    public void testSaveMessageResponse() {
        Message originalMessage = MessageTDF.createMessage(TEST_MESSAGE, USER_ID);
        Message response = MessageTDF.createMessageResponse(TEST_MESSAGE, USER_ID, originalMessage.getId());

        Message result = messageRepository.save(response);

        assertNotNull(result.getId());
        assertEquals(response.getText(), result.getText());
        assertEquals(response.getOriginalMessageId(), result.getOriginalMessageId());
    }

    @Test
    public void testFindMessageByUser() {
        Long userId = 1L;
        Message message = MessageTDF.createMessage(TEST_MESSAGE, userId);
        messageRepository.save(message);

        List<Message> result = messageRepository.findByUserIdAndOriginalMessageIdIsNull(userId);

        assertEquals(1, result.size());
        assertEquals(TEST_MESSAGE, result.get(0).getText());
    }

    @Test
    public void testFindMessageByOriginalMessageId() {
        Message message = MessageTDF.createMessage(TEST_MESSAGE, null);
        messageRepository.save(message);
        Message response = MessageTDF.createMessageResponse(TEST_MESSAGE, null, message.getId());
        messageRepository.save(response);

        List<Message> result = messageRepository.findByOriginalMessageId(message.getId());

        assertEquals(1, result.size());
        assertEquals(TEST_MESSAGE, result.get(0).getText());
        assertEquals(message.getId(), result.get(0).getOriginalMessageId());
    }

    @Before
    public void setUp() {
        messageRepository.deleteByOriginalMessageIdIsNotNull();
        messageRepository.deleteAll();
    }

    @After
    public void tearDown() {
        messageRepository.deleteByOriginalMessageIdIsNotNull();
        messageRepository.deleteAll();
    }


}
