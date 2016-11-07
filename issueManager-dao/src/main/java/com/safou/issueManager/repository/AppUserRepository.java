package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.safou.issueManager.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = "select user from AppUser user where user.appUserCredential.login = ?1 ")
    AppUser findByLogin(String login);
}
