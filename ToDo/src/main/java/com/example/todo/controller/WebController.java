package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.todo.dao.Todo;
import com.example.todo.dao.TodoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todo")
public class WebController {
	@Autowired
	TodoService service;

	@GetMapping
	public String getallTodo(Model m) {
		List<Todo> todo = service.getAll();
		m.addAttribute("todo", todo);
		return "index";
	}

	@GetMapping("/add")
	public String redirecttoAdd(Model m) {
		m.addAttribute("todo", new Todo());
		return "add";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "add";
		}

		service.save(todo);
		return "redirect:/todo";
	}

	@GetMapping("/update")
	public ModelAndView update(@RequestParam String id, ModelAndView m) {
		int i = Integer.parseInt(id);
		Todo t = service.findById(i);
		// t.setLastDate(null);
		m.addObject("todo", t);
		m.setViewName("update");
		return m;
	}

	@PostMapping("/updateTodo")
	public String updateEmp(@ModelAttribute("todo") Todo todo, @RequestParam String lastDate) {
		System.out.println(lastDate);
		service.save(todo);
		return "redirect:/todo";
	}
}
