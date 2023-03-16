package com.domo.springhexagonalexample.adpater.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTodoRequest {
	private String title;
	private String description;
}
