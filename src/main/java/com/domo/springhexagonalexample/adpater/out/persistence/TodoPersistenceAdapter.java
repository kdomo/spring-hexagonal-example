package com.domo.springhexagonalexample.adpater.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.domo.springhexagonalexample.application.port.out.TodoPort;
import com.domo.springhexagonalexample.domain.Todo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoPersistenceAdapter implements TodoPort {
	private final TodoMapper todoMapper;
	private final TodoRepository todoRepository;

	@Override
	public void save(Todo todo) {
		TodoEntity todoEntity = todoMapper.toEntity(todo);
		todoRepository.save(todoEntity);
	}

	@Override
	public void delete(Todo todo) {
		TodoEntity todoEntity = todoMapper.toEntity(todo);
		todoRepository.delete(todoEntity);
	}

	@Override
	public Todo load(Long id) {
		TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(IllegalAccessError::new);
		return todoMapper.toDomain(todoEntity);
	}

	@Override
	public List<Todo> loadAll() {
		return todoRepository.findAll().stream()
				.map(todoEntity -> todoMapper.toDomain(todoEntity))
				.collect(Collectors.toList());
	}
}
