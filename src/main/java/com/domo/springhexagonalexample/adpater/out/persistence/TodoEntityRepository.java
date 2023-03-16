package com.domo.springhexagonalexample.adpater.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoEntityRepository extends JpaRepository<TodoEntity, Long>, TodoRepository {
}
