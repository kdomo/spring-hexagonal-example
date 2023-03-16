package com.domo.springhexagonalexample.application.port.in;

import java.util.List;

import com.domo.springhexagonalexample.adpater.in.CreateTodoRequest;
import com.domo.springhexagonalexample.domain.Todo;
import com.domo.springhexagonalexample.adpater.in.UpdateTodoRequest;

public interface TodoUseCase {
	void createTodo(CreateTodoRequest todoRequest);

	List<Todo> getAllTodos();

	void updateTodo(Long id, UpdateTodoRequest todoRequest);

	void deleteTodo(Long id);
}
