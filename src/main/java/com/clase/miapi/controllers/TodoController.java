package com.clase.miapi.controllers;

import com.clase.miapi.data.Database;
import com.clase.miapi.data.models.Todos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by edwin on May, 2019
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    @GetMapping
    public List<Todos.Todo> findAll(){
        return (List<Todos.Todo>) Database.select(Todos.instance);
    }

    @GetMapping("/{id}")
    public Todos.Todo findById(@PathVariable("id") int id){
        return (Todos.Todo) Database.select(Todos.instance, id);
    }

    @PostMapping
    public Todos.Todo insert(@RequestBody Todos.Todo todo){
        return (Todos.Todo) Database.create(Todos.instance, todo);
    }

    @PutMapping("/{id}")
    public Todos.Todo update(@RequestBody Todos.Todo todo, @PathVariable("id") int id){
        return (Todos.Todo) Database.update(Todos.instance, todo, id);
    }

    @DeleteMapping("/{id}")
    public Todos.Todo delete(@PathVariable("id") int id){
        return (Todos.Todo) Database.delete(Todos.instance, id);
    }
}
