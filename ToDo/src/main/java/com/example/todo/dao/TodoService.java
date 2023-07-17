package com.example.todo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	@Autowired
	TodoDao dao;

	public List<Todo> getAll() {
		return dao.findAll();
	}

	public Todo getTodo(int id) {
		return dao.findById(id).get();
	}

	public void delete(int id) {
		Todo t = this.getTodo(id);
		dao.delete(t);
	}

	public void save(@Valid Todo todo) {
		dao.save(todo);

	}

	public Todo findById(int i) {
		// TODO Auto-generated method stub
		return this.getTodo(i);
	}
}
