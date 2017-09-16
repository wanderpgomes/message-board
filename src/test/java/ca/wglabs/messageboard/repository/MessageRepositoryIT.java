package ca.wglabs.messageboard.repository;

import ca.wglabs.messageboard.config.DataSourceConfiguration;
import ca.wglabs.messageboard.config.PersistenceConfiguration;
import ca.wglabs.messageboard.model.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

    @Test
    public void testSaveMessage() {
        Message message = createMessage("hello!");

        Message result = messageRepository.save(message);

        assertNotNull(result.getId());
        assertEquals(message.getText(), result.getText());
    }


    @After
    public void tearDown() {
        messageRepository.deleteAll();
    }

    @Before
    public void setUp() {
        messageRepository.deleteAll();
    }

    private Message createMessage(String text) {
        Message message =  new Message();
        message.setText(text);
        return message;
    }

}
