package com.anouarDev.facebookApp.controller;
import com.anouarDev.facebookApp.dto.AppUsersDto;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.repository.UserRepository;
import com.anouarDev.facebookApp.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/v1/user")
public class UserController {

    private final UsersService userService;
    private final UserRepository userRepository;

    @GetMapping("{id}")
    public Optional<Users> findUserById(@PathVariable("id") Long id) {
        return this.userService.findUserById(id);

    }

    @GetMapping("/friends/{id}")
    public List<Users> getFriendsForUser(@PathVariable("id") Long id) {
        List<Users> friends = this.userRepository.findById(id).get().getFriends();
        return friends;
    }



    @PostMapping("/login")
    public Users login(@RequestBody Users user) throws AccountNotFoundException {
        return this.userService.login(user);
    }

    @GetMapping("/find-all")
    public List<Users> findAll(){
        return this.userService.findAll();
    }

    @GetMapping("/find-all/friend-suggestions")
    public List<AppUsersDto> findAllSuggestions(){
        return this.userService.findAllSuggestions();
    }


}
