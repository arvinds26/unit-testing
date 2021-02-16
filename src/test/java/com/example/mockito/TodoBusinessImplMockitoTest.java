package com.example.mockito;

import com.example.service.TodoService;
import com.example.serviceimpl.TodoBusinessImpl;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockitoTest {

  @Test
  public void usingMockito() {
    TodoService todoService = mock(TodoService.class);
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("Spring")).thenReturn(allTodos);
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
    List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
    assertEquals(2, todos.size());
  }

  @Test
  public void usingMockito_UsingBDD() {
    TodoService todoService = mock(TodoService.class);
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    // given
    given(todoService.retrieveTodos("Spring")).willReturn(allTodos);
    // when
    List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
    // then
    assertThat(todos.size(), is(2));
  }

  @Test
  public void letsTestDeleteNow() {
    TodoService todoService = mock(TodoService.class);
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("Spring")).thenReturn(allTodos);
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
    todoBusinessImpl.deleteTodosNotRelatedToSpring("Spring");
    verify(todoService).deleteTodo("Learn to Dance");
    verify(todoService, never()).deleteTodo("Learn Spring MVC");
    verify(todoService, never()).deleteTodo("Learn Spring");
    verify(todoService, times(1)).deleteTodo("Learn to Dance");
    // atLeastOnce, atLeast
  }

  @Test
  public void captureArgument() {
    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
    TodoService todoService = mock(TodoService.class);
    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("Spring")).thenReturn(allTodos);
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
    todoBusinessImpl.deleteTodosNotRelatedToSpring("Spring");
    verify(todoService).deleteTodo(argumentCaptor.capture());
    assertEquals("Learn to Dance", argumentCaptor.getValue());
  }
}
