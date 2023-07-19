package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.dto.AppUsersDto;
import com.anouarDev.facebookApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);

    @Query("SELECT " +
            "new com.anouarDev.facebookApp.dto.AppUsersDto(u.id, u.firstName, u.lastName)" +
            "FROM Users u")
    List<AppUsersDto> findAllAppUsersDto();

}