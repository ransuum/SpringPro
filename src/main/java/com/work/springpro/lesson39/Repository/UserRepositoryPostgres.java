package com.work.springpro.lesson39.Repository;

import com.work.springpro.lesson39.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepositoryPostgres extends JpaRepository<User, Integer> {
    User findByNameAndSurnameAndEmail(String name, String surname, String email);
    User getUserByEmailAndPhone(String email, String phone);
    @Transactional
    @Modifying
    @Query("update User u set u.name=?1 where u.id=?2")
    Integer Update(String name, Integer id);
}
