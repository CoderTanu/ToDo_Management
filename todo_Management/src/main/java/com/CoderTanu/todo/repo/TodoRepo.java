package com.CoderTanu.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CoderTanu.todo.entity.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long>{

}
