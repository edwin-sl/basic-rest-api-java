package com.clase.miapi.data.models;

import java.util.Arrays;

/**
 * Created by edwin on May, 2019
 */
public class Todos extends Resource<Todos.Todo> {
    {
        data.addAll(Arrays.asList(
           new Todo(1, "lunch", "go for lunch", 1)
        ));
    }
    public static Todos instance = new Todos();
    private Todos(){}

    public static class Todo extends Resource.Model{
        public String title;
        public String description;
        public int userId;

        public Todo() {
        }

        public Todo(int id, String title, String description, int userId) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.userId = userId;
        }
    }
}
