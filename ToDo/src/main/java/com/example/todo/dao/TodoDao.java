package com.example.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<Todo, Integer> {

}
