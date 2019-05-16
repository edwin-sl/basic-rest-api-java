package com.clase.miapi.controllers;

import com.clase.miapi.data.Database;
import com.clase.miapi.data.models.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by edwin on May, 2019
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<Users.User> findAll(){
        return (List<Users.User>) Database.select(Users.instance);
    }

    @GetMapping("/{id}")
    public Users.User findById(@PathVariable("id") int id){
        return (Users.User) Database.select(Users.instance, id);
    }

    @PostMapping
    public Users.User insert(@RequestBody Users.User user){
        return (Users.User) Database.create(Users.instance, user);
    }

    @PutMapping("/{id}")
    public Users.User update(@RequestBody Users.User user, @PathVariable("id") int id){
        return (Users.User) Database.update(Users.instance, user, id);
    }

    @DeleteMapping("/{id}")
    public Users.User delete(@PathVariable("id") int id){
        return (Users.User) Database.delete(Users.instance, id);
    }
}
