package com.yakidan.spring.spring_boot.repository;

import com.yakidan.spring.spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.nickname=?1")
    public User findByNickname(String nickname);

}
