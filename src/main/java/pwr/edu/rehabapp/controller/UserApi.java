package pwr.edu.rehabapp.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pwr.edu.rehabapp.model.dto.UserDto;
import pwr.edu.rehabapp.service.UserService;

@AllArgsConstructor
@RestController
@RequestMapping
public class UserApi {

    private UserService users;

    @GetMapping("api/admin/user/all")
    public Iterable<UserDto> getAllUsers() {
        return users.findAll();
    }

    @GetMapping("api/doctor/user")
    public UserDto getUserByNumber(@RequestParam long number) {
        return users.findByNumber(number);
    }


    @PostMapping("api/doctor/user")
    public UserDto registerUser(@RequestBody UserDto userdto) {
        return users.save(userdto);
    }



    // TODO: fill AccountDto class and create method which implements login logic in SecurityConfig
//    @PostMapping("api/doctor/user")
//    public ResponseEntity<?> loginUser(@RequestBody AccountDto accountDto) {
//        return null;
//    }

    @PutMapping("api/user/isonline")
    public void updateIsOnline(@RequestParam long number, @RequestParam boolean online) {
        users.setOnlineByNumber(number, online);
    }
    //

    @DeleteMapping("api/admin/user")
    public void deleteUser(@RequestParam long number) {
        users.deleteByNumber(number);
    }

    @PutMapping("api/user/updatename")
    public void updateName(@RequestParam long number, @RequestParam String name) {
        users.setNameByNumber(number, name);
    }

    @PutMapping("api/user/updateusername")
    public void updateUsername(@RequestParam long number, @RequestParam String username) {
        users.setUsernameByNumber(number, username);
    }

    @PutMapping("api/user/username")
    public void updatePassword(@RequestParam long number, @RequestParam String password) {
        users.setPasswordByNumber(number, password);
    }


}
