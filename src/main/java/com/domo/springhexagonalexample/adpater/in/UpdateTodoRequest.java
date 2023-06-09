package com.domo.springhexagonalexample.adpater.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateTodoRequest {
	private String title;
	private String description;
	private Boolean completed;
}
