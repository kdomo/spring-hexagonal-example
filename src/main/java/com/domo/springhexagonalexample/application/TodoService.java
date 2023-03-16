package com.domo.springhexagonalexample.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domo.springhexagonalexample.application.port.in.TodoUseCase;
import com.domo.springhexagonalexample.adpater.in.CreateTodoRequest;
import com.domo.springhexagonalexample.application.port.out.TodoPort;
import com.domo.springhexagonalexample.domain.Todo;
import com.domo.springhexagonalexample.adpater.in.UpdateTodoRequest;
import com.domo.springhexagonalexample.adpater.out.persistence.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService implements TodoUseCase {
	private final TodoRepository todoRepository;
	private final TodoPort todoPort;

	@Override
	@Transactional
	public void createTodo(CreateTodoRequest createTodoRequest) {
		Todo todo = Todo.builder()
				.title(createTodoRequest.getTitle())
				.description(createTodoRequest.getDescription())
				.completed(false)
				.build();
		todoPort.save(todo);
	}

	@Override
	@Transactional
	public void updateTodo(Long id, UpdateTodoRequest updateTodoRequest) {
		Todo todo = todoPort.load(id);
		todo.update(updateTodoRequest.getTitle(), updateTodoRequest.getDescription(), updateTodoRequest.getCompleted());
		todoPort.save(todo);
	}

	@Override
	public void deleteTodo(Long id) {
		Todo todo = todoPort.load(id);
		todoPort.delete(todo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Todo> getAllTodos() {
		return todoPort.loadAll();
	}
}
