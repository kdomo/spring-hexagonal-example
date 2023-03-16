package com.domo.springhexagonalexample.application.port.out;

import java.util.List;

import com.domo.springhexagonalexample.domain.Todo;

public interface TodoPort {
	void save(Todo todo);
	void delete(Todo todo);
	Todo load(Long id);
	List<Todo> loadAll();
}
