package com.domo.springhexagonalexample.dto;

import com.domo.springhexagonalexample.domain.Todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {
	private Long id;
	private String title;
	private String description;
	private Boolean completed;

	public static TodoDto from(Todo todo) {
		return TodoDto.builder()
				.id(todo.getId())
				.title(todo.getTitle())
				.description(todo.getDescription())
				.completed(todo.getCompleted())
				.build();
	}
}
