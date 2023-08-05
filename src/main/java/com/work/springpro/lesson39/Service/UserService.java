package com.work.springpro.lesson39.Service;

import com.work.springpro.lesson39.Controller.UserDto.IntegerDto;
import com.work.springpro.lesson39.Entity.User;
import com.work.springpro.lesson39.Repository.UserRepositoryPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepositoryPostgres userRepositoryPostgres;

    @Autowired
    public UserService(UserRepositoryPostgres userRepositoryPostgres) {
        this.userRepositoryPostgres = userRepositoryPostgres;
    }

    public User getUserByEmailAndPhone(String email, String phone) {
        return userRepositoryPostgres.getUserByEmailAndPhone(email, phone);
    }

    public List<User> getAll() {
        return userRepositoryPostgres.findAll();
    }

    public Optional<User> getById(Integer id) {
        return userRepositoryPostgres.findById(id);
    }

    public User save(User user) {
        return userRepositoryPostgres.save(user);
    }

    public User update(User user) {
        return userRepositoryPostgres.save(user);
    }

    public Integer delete(int id) {
        userRepositoryPostgres.deleteById(id);
        return id;
    }

    public User findByNameAndSurnameAndEmail(String name, String surname, String email) {
        return userRepositoryPostgres.findByNameAndSurnameAndEmail(name, surname, email);
    }

    public Integer UpdateById(String name, Integer id) {
        return userRepositoryPostgres.Update(name, id);
    }
}
