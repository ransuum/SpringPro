package com.work.springpro.lesson39.Repository;

import com.work.springpro.lesson39.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
//    @PostConstruct
//    public void init(){
//        users.add(new User(1, "Dima", "Yangicher", "dima@mail.ua", "3809719653",19));
//        users.add(new User(2, "artem", "koval", "artem@mail.ua", "38067105188",19));
//        users.add(new User(3, "val", "dmitr", "val@mail.ua", "380686582232",19));
//    }
    public List<User> getAll(){
        return users;
    }
    public User getById(Integer id){
        return users.get(id);
    }
    public User save(User user){
        users.add(user);
        user.setId(users.size()-1);
        return user;
    }

    public User update(Integer id, User user){
       final User oldUser = users.get(id);
       oldUser.setName(user.getName());
       return users.get(id);
    }
    public Integer delete(int id){
        users.remove(id);
        return id;
    }
    public User SearchOnThreeParam(String name, String surname, String email){
        return null;
    }
}
