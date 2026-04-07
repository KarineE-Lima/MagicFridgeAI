package com.teste.MagicFridgeAI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teste.MagicFridgeAI.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByLogin(String login);
}
