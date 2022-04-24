package pwr.edu.rehabapp.service.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwr.edu.rehabapp.dto.UserDto;
import pwr.edu.rehabapp.mapper.UserMapper;
import pwr.edu.rehabapp.entity.User;
import pwr.edu.rehabapp.repository.UserRepo;

import java.util.List;

@Service
public class UserManager {

    private UserRepo userRepo;

    @Autowired
    public UserManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserDto findById(Long id){
        User user = userRepo.findById(id).get();
        return UserMapper.mapUserToUserDto(user);
    }

    public Iterable<UserDto> findAll(){
        List<User> users = userRepo.findAll();
        return UserMapper.mapUserListToUserDtoList(users);
    }

    public User save(User user){
        return userRepo.save(user);
    }

    public void deleteById(Long id){
        userRepo.deleteById(id);
    }


}
