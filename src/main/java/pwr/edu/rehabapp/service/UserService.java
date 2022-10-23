package pwr.edu.rehabapp.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pwr.edu.rehabapp.model.dto.UserDto;
import pwr.edu.rehabapp.mapper.UserMapper;
import pwr.edu.rehabapp.model.entity.User;
import pwr.edu.rehabapp.repository.UserRepo;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    final private UserRepo userRepo;

    public User findUserByNumber(long number){
        return userRepo.findByNumber(number);
    }


    public UserDto findByNumber(long number){
        User user = findUserByNumber(number);
        return UserMapper.mapUserToUserDto(user);
    }

    public Iterable<UserDto> findAll(){
        List<User> users = userRepo.findAll();
        return UserMapper.mapUserListToUserDtoList(users);
    }

    public UserDto save(UserDto userDto){
        User user = UserMapper.mapUserDtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return UserMapper.mapUserToUserDto(savedUser);
    }

    public void deleteByNumber(long number){
        userRepo.delete(
                userRepo.findByNumber(number)
        );
    }

    public void setOnlineByNumber( Long number, boolean online) {
        findUserByNumber(number).setOnline(online);
    }

    public void setNameByNumber(Long number, String name){
        findUserByNumber(number).setName(name);
    }

    public void setUsernameByNumber(Long number, String username){
        findUserByNumber(number).setName(username);
    }

    public void setPasswordByNumber(Long number, String password){
        findUserByNumber(number).setName(password);
    }
}
