package com.domo.springhexagonalexample.adpater.out.persistence;

import org.springframework.stereotype.Component;

import com.domo.springhexagonalexample.domain.Todo;

@Component
public class TodoMapper {
	public Todo toDomain(TodoEntity entity) {
		return Todo.builder()
				.id(entity.getId())
				.title(entity.getTitle())
				.description(entity.getDescription())
				.completed(entity.getCompleted())
				.build();
	}

	public TodoEntity toEntity(Todo domain) {
		return TodoEntity.builder()
				.id(domain.getId() == null ? null : domain.getId())
				.title(domain.getTitle())
				.description(domain.getDescription())
				.completed(domain.getCompleted())
				.build();
	}

}
