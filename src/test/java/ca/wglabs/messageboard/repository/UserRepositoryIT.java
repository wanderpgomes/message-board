package ca.wglabs.messageboard.repository;

import ca.wglabs.messageboard.config.DataSourceConfiguration;
import ca.wglabs.messageboard.config.PersistenceConfiguration;
import ca.wglabs.messageboard.model.Message;
import ca.wglabs.messageboard.model.User;
import ca.wglabs.messageboard.tdf.MessageTDF;
import ca.wglabs.messageboard.tdf.UserTDF;
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
public class UserRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    private static final String USER_NAME = "test_user";

    @Test
    public void testSaveUser() {
        User user = UserTDF.createUser(USER_NAME);

        User result = userRepository.save(user);

        assertNotNull(result.getId());
        assertEquals(user.getName(), result.getName());
    }


    @After
    public void tearDown() {
        userRepository.deleteByName(USER_NAME);
    }


}
