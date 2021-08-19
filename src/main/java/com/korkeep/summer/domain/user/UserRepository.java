package com.korkeep.summer.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // findByEmail: email 값으로 중복 사용자 판단
    Optional<User> findByEmail(String email);
}
