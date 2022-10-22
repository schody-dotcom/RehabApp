package pwr.edu.rehabapp.mapper;

import pwr.edu.rehabapp.model.dto.UserDto;
import pwr.edu.rehabapp.model.entity.Account;
import pwr.edu.rehabapp.model.entity.User;
import pwr.edu.rehabapp.model.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDto mapUserToUserDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setEmail(user.getAccount().getEmail());
        userDto.setNumber(user.getNumber());
        userDto.setRole(user.getAccount().getRole().toString());
        userDto.setOnline(user.isOnline());
        userDto.setPassword(user.getAccount().getPassword());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());

        return userDto;
    }

    public static List<UserDto> mapUserListToUserDtoList(List<User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            usersDto.add(mapUserToUserDto(user));
        }
        return usersDto;
    }

    public static User mapUserDtoToUser(UserDto userDto){
        User user = new User();

        Account account = new Account();
        account.setEmail(userDto.getEmail());
        account.setPassword(userDto.getPassword());
        user.setNumber(userDto.getNumber());
        user.setAccount(account);
        account.setRole(Role.valueOf(userDto.getRole()));
        user.setOnline(userDto.isOnline());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());




        return user;
    }
}
