package ca.wglabs.messageboard.rest.controller;


import ca.wglabs.messageboard.dto.MessageDto;
import ca.wglabs.messageboard.tdf.MessageTDF;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageBoardRestControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testPing() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity("/ping", String.class);
        assertThat(response.getBody(), containsString("Ping:"));
    }

    @Test
    public void testAddMessage() throws Exception {
        MessageDto message = MessageTDF.createMessageDto("Hello!");
        ResponseEntity<MessageDto> response = restTemplate.postForEntity("/messages", message, MessageDto.class);

        assertThat(response.getBody().getText(), equalTo("Hello!"));
    }
}
