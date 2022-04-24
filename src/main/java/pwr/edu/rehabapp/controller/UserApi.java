package pwr.edu.rehabapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwr.edu.rehabapp.dto.UserDto;
import pwr.edu.rehabapp.entity.User;
import pwr.edu.rehabapp.service.manager.UserManager;

@RestController
@RequestMapping
public class UserApi {

    private UserManager users;

    @Autowired
    public UserApi(UserManager users) {
        this.users = users;
    }

    @GetMapping("api/user/all")
    public Iterable<UserDto> getAllUsers() {
        return users.findAll();
    }

    @GetMapping("api/user")
    public UserDto getUserById(@RequestParam Long index) {
        return users.findById(index);
    }

    @PostMapping("api/admin/user")
    public User addUser(@RequestBody User user ){
        return  users.save(user);
    }

    @PutMapping("api/admin/user")
    public User updateUser(@RequestBody User user ){
        return  users.save(user);
    }

    @DeleteMapping("api/admin/user")
    public void deleteUser(@RequestBody Long index){
        users.deleteById(index);
    }

    @PatchMapping("api/admin/user")
    public User partlyUpdateUser(@RequestBody User user ){
        return  users.save(user);
    }
}
