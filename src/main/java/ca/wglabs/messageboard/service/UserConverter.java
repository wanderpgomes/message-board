package ca.wglabs.messageboard.service;

import ca.wglabs.messageboard.dto.UserDto;
import ca.wglabs.messageboard.model.User;

import java.util.Objects;

public class UserConverter {

    public static User toEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());

        return user;
    }

    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(Objects.toString(user.getId(), ""));
        userDto.setName(user.getName());

        return userDto;
    }
}
