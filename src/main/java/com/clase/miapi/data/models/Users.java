package com.clase.miapi.data.models;

import java.util.Arrays;

/**
 * Created by edwin on May, 2019
 */
public class Users extends Resource<Users.User> {
    {
        data.addAll(Arrays.asList(
                new User(1, "Edwin", "Salinas"))
        );
    }
    public static Users instance = new Users();
    private Users(){}

    public static class User extends Resource.Model{
        public String name;
        public String lastName;

        public User(){}
        public User(
                int id,
                String name,
                String lastName) {
            this.id = id;
            this.name = name;
            this.lastName = lastName;
        }
    }
}
