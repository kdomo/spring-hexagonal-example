package com.domo.springhexagonalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domo.springhexagonalexample.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
