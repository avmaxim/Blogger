package com.flogger.repositories;

import com.flogger.IRepository;
import com.flogger.domains.Role;
import com.flogger.domains.User;

import java.util.ArrayList;
import java.util.List;

/* UserRepository is represented as stub class for now */
public class UserRepository implements IRepository<User>{

    @Override
    public User getById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("avmax19");
        user.setPassword("1234567890");
        user.setEmail("avmax19@gmail.com");
        Role role = new Role();
        role.setRoleName("Admin");
        user.setRole(role);
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.add(getById(1));
        users.add(getById(2));
        users.add(getById(3));
        return users;
    }

    @Override
    public Boolean insert(User user) {
        return true;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
