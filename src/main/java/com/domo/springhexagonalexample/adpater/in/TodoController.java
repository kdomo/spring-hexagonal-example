package com.domo.springhexagonalexample.adpater.in;

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

import com.domo.springhexagonalexample.application.port.in.TodoUseCase;
import com.domo.springhexagonalexample.domain.Todo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {
	private final TodoUseCase todoUseCase;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Todo> getAllTodos() {
		return todoUseCase.getAllTodos();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createTodo(@RequestBody CreateTodoRequest todoRequest){
		todoUseCase.createTodo(todoRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateTodo(@PathVariable Long id, @RequestBody UpdateTodoRequest todoRequest){
		todoUseCase.updateTodo(id, todoRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteTodo(@PathVariable Long id){
		todoUseCase.deleteTodo(id);
	}
}
