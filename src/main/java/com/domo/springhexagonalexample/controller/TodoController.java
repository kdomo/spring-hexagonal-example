package com.domo.springhexagonalexample.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.domo.springhexagonalexample.dto.CreateTodoRequest;
import com.domo.springhexagonalexample.dto.TodoDto;
import com.domo.springhexagonalexample.dto.UpdateTodoRequest;
import com.domo.springhexagonalexample.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<TodoDto> getAllTodos() {
		return todoService.getAllTodos();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createTodo(@RequestBody CreateTodoRequest todoRequest){
		todoService.createTodo(todoRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateTodo(@PathVariable Long id, @RequestBody UpdateTodoRequest todoRequest){
		todoService.updateTodo(id, todoRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteTodo(@PathVariable Long id){
		todoService.deleteTodo(id);
	}
}
