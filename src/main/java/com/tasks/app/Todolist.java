
package com.tasks.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todolist {
  @Id
  private String id;
  private String task;
  private String status;
}