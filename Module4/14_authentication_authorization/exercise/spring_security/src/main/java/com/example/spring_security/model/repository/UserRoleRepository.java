package com.example.spring_security.model.repository;

import com.example.spring_security.model.entity.AppUser;
import com.example.spring_security.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
