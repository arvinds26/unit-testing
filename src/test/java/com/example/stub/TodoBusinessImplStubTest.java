package com.example.stub;

import com.example.service.TodoService;
import com.example.serviceimpl.TodoBusinessImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplStubTest {

  @Test
  public void usingAStub() {
    TodoService todoService = new TodoServiceStub();
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
    List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
    assertEquals(2, todos.size());
  }
}
