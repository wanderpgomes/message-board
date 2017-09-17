package ca.wglabs.messageboard.tdf;

import ca.wglabs.messageboard.model.User;

public class UserTDF {

    public static User createUser(String name){
        User user = new User();
        user.setName(name);
        return user;
    }
}
