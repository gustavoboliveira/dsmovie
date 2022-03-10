package com.gustavoboliveira.dsmovie.repositories;

import com.gustavoboliveira.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
