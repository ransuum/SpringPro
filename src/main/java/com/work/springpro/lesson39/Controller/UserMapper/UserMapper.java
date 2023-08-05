package com.work.springpro.lesson39.Controller.UserMapper;

import com.work.springpro.lesson39.Controller.UserDto.UserDto;
import com.work.springpro.lesson39.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto UserToDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPhone(),
                user.getAge()
        );
    }
    public User toEntity(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getAge()
        );
    }
}
