package com.domo.springhexagonalexample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domo.springhexagonalexample.dto.CreateTodoRequest;
import com.domo.springhexagonalexample.dto.TodoDto;
import com.domo.springhexagonalexample.dto.UpdateTodoRequest;
import com.domo.springhexagonalexample.domain.Todo;
import com.domo.springhexagonalexample.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
	private final TodoRepository todoRepository;

	@Transactional
	public void createTodo(CreateTodoRequest createTodoRequest) {
		Todo todo = Todo.builder()
				.title(createTodoRequest.getTitle())
				.description(createTodoRequest.getDescription())
				.completed(false)
				.build();
		todoRepository.save(todo);
	}

	@Transactional
	public void updateTodo(Long id, UpdateTodoRequest updateTodoRequest) {
		final Todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("todo not found with id: " + id));
		todo.update(updateTodoRequest.getTitle(), updateTodoRequest.getDescription(), updateTodoRequest.getCompleted());
	}

	public void deleteTodo(Long id) {
		final Todo todo = todoRepository.findById(id)
						.orElseThrow(() -> new IllegalArgumentException("todo not found with id: " + id));
		todoRepository.delete(todo);
	}

	public List<TodoDto> getAllTodos() {
		return todoRepository.findAll().stream()
				.map(TodoDto::from)
				.collect(Collectors.toList());
	}
}
