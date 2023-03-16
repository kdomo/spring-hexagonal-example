package com.domo.springhexagonalexample.adpater.out.persistence;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
	TodoEntity save(TodoEntity todoEntity);

	Optional<TodoEntity> findById(Long id);

	void delete(TodoEntity todoEntity);

	List<TodoEntity> findAll();
}
