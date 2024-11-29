package com.juanguijordan.mspoc.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.juanguijordan.mspoc.authserver.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
