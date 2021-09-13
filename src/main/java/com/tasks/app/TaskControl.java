package com.tasks.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class TaskControl {

  @Autowired
  private ManageTask manageTask;

  @GetMapping("/")
  public List<Todolist> GetTodos() {
    return manageTask.findAll();
  }

  @PostMapping("/")
    public Todolist postMethodName(@RequestBody Todolist todo) {
        return manageTask.save(todo);
    }

  @PutMapping("/{id}")
  public Todolist PutMapping(@PathVariable String id) {
    Todolist oldTask = manageTask.findById(id).orElse(null);
    oldTask.setStatus("completed"); //sets the status of the task as completed when checkbox is checked
    manageTask.save(oldTask);
    return oldTask;
    }
  
  @DeleteMapping("/{id}")
  public String DeleteUser(@PathVariable String id) {
    manageTask.deleteById(id);
    return id;
  }
}