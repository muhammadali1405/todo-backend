package com.tasks.app;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ManageTask extends MongoRepository<Todolist, String> {
  Optional<Todolist> findById(String id);  
  List<Todolist> findByTask(String task);
  List<Todolist> findByStatus(String status);
}