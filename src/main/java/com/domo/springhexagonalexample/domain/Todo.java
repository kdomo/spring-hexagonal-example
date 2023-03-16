package com.domo.springhexagonalexample.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Todo {
	private Long id;
	private String title;
	private String description;
	private Boolean completed;

	public void update(String title, String description, Boolean completed) {
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
}
