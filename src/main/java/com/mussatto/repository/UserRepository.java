package com.mussatto.repository;

import com.mussatto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mussatto on 23/10/16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
