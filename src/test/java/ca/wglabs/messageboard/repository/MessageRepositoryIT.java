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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfiguration.class, PersistenceConfiguration.class})
public class MessageRepositoryIT {

    @Autowired
    protected MessageRepository messageRepository;

    private static final String TEST_MESSAGE = "test message";


    @Test
    public void testSaveMessage() {
        Message message = MessageTDF.createMessage(TEST_MESSAGE);

        Message result = messageRepository.save(message);

        assertNotNull(result.getId());
        assertEquals(message.getText(), result.getText());
    }

    @After
    public void tearDown() {
        messageRepository.deleteByText(TEST_MESSAGE);
    }


}
