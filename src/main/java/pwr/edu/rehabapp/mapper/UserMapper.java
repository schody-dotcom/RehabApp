package pwr.edu.rehabapp.mapper;

import pwr.edu.rehabapp.dto.UserDto;
import pwr.edu.rehabapp.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDto mapUserToUserDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setEmail(user.getAccount().getEmail());
        userDto.setNumber(user.getNumber());
        userDto.setRole(user.getRole());
        userDto.setOnline(user.isOnline());
        userDto.setPassword(user.getAccount().getPassword());
        userDto.setName(user.getName());
        userDto.setName(user.getUsername());

        return userDto;
    }

    public static List<UserDto> mapUserListToUserDtoList(List<User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            usersDto.add(mapUserToUserDto(user));
        }
        return usersDto;
    }
}
