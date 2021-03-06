package ca.wglabs.messageboard.rest.controller;


import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.dto.UserDto;
import ca.wglabs.messageboard.repository.MessageRepository;
import ca.wglabs.messageboard.tdf.MessageTDF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageBoardRestControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MessageRepository messageRepository;

    private static final String MESSAGE = "IT test message";


    @Test
    public void testPing() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity("/ping", String.class);
        assertThat(response.getBody(), containsString("Ping:"));
    }

    @Test
    public void testAddMessage() throws Exception {
        MessageDto message = MessageTDF.createMessageDto(MESSAGE, 1L, "Toronto", 20.0d, 43.7d, -79.42d);
        ResponseEntity<MessageDto> response = restTemplate.postForEntity("/messages", message, MessageDto.class);

        assertThat(response.getBody().getText(), equalTo(MESSAGE));
        assertThat(response.getBody().getCity(), equalTo("Toronto"));
    }

    @Test
    public void testGetMessages() throws Exception {

        MessageDto message1 = MessageTDF.createMessageDto(MESSAGE);
        restTemplate.postForEntity("/messages", message1, MessageDto.class);
        MessageDto message2 = MessageTDF.createMessageDto(MESSAGE);
        restTemplate.postForEntity("/messages", message2, MessageDto.class);

        // TODO: Use a dedicated test database so we can delete all messages.
        ResponseEntity<MessageDto[]> responseEntity = restTemplate.getForEntity("/messages", MessageDto[].class);
        List<MessageDto> response = Arrays.asList(responseEntity.getBody());

        assertThat(response.size(), equalTo(2));
        assertThat(response.get(0).getText(), equalTo(MESSAGE));
        assertThat(response.get(1).getText(), equalTo(MESSAGE));
    }

    @Test
    public void testGetMessagesByUser() throws Exception {

        MessageDto message1 = MessageTDF.createMessageDto(MESSAGE, 1L);
        restTemplate.postForEntity("/messages", message1, MessageDto.class);
        MessageDto message2 = MessageTDF.createMessageDto(MESSAGE, 2L);
        restTemplate.postForEntity("/messages", message2, MessageDto.class);

        // TODO: Use a dedicated test database so we can delete all messages.
        ResponseEntity<MessageDto[]> responseEntity = restTemplate.getForEntity("/messages?userId=1", MessageDto[].class);
        List<MessageDto> response = Arrays.asList(responseEntity.getBody());

        assertThat(response.size(), equalTo(1));
        assertThat(response.get(0).getText(), equalTo(MESSAGE));
    }


    @Test
    public void testGetResponses() throws Exception {

        MessageDto message = MessageTDF.createMessageDto(MESSAGE, 1L);
        ResponseEntity<MessageDto> rsp = restTemplate.postForEntity("/messages", message, MessageDto.class);
        MessageDto messageResponse = MessageTDF.createMessageResponseDto(MESSAGE, 2L, rsp.getBody().getId());
        restTemplate.postForEntity("/messages", messageResponse, MessageDto.class);

        ResponseEntity<MessageDto[]> responseEntity = restTemplate.getForEntity("/responses?originalMessageId="+rsp.getBody().getId(), MessageDto[].class);
        List<MessageDto> response = Arrays.asList(responseEntity.getBody());

        assertThat(response.size(), equalTo(1));
        assertThat(response.get(0).getText(), equalTo(MESSAGE));
    }

    @Test
    public void testGetUsers() throws  Exception {

        ResponseEntity<UserDto[]> responseEntity = restTemplate.getForEntity("/users", UserDto[].class);
        List<UserDto> response = Arrays.asList(responseEntity.getBody());

        assertThat(response.size(), equalTo(4));
        assertThat(response.get(0).getName(), equalTo("James"));

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
