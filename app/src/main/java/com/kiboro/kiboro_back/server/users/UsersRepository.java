package com.kiboro.kiboro_back.server.users;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kiboro.kiboro_back.domain.entity.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
