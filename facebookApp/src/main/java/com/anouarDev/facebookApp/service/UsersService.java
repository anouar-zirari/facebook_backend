package com.anouarDev.facebookApp.service;

import com.anouarDev.facebookApp.dto.AppUsersDto;
import com.anouarDev.facebookApp.model.Users;
import com.anouarDev.facebookApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {

    private final UserRepository userRepository;

    public void saveUser(Users user) {
        this.userRepository.save(user);
    }

    public Optional<Users> findUserById(Long id) {
        return this.userRepository.findById(id);
    }

    public Users login(Users user) throws AccountNotFoundException {
        Users userInDb = this.userRepository.findByEmail(user.getEmail());
        String userFirstname = userInDb.getFirstName();
        System.out.println("this the the user" + userFirstname);
        if (userInDb.getPassword().equals(user.getPassword()))
            return userInDb;
        else
            throw new AccountNotFoundException();
    }

    public List<Users> findAll(){
        return this.userRepository.findAll();
    }

    public List<AppUsersDto> findAllSuggestions() {
        return this.userRepository.findAllAppUsersDto();
    }


}
