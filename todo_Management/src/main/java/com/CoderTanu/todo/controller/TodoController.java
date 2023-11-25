package com.CoderTanu.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CoderTanu.todo.dto.TodoDto;
import com.CoderTanu.todo.service.impl.TodoServiceImpl;


@RestController
@RequestMapping("api/todos/")

public class TodoController {
	
	

	public TodoController(TodoServiceImpl todoServiceImpl) {
	
		this.todoServiceImpl = todoServiceImpl;
	}
	private TodoServiceImpl todoServiceImpl;
	
	
	
	
	
	@PostMapping
	public ResponseEntity<TodoDto>  addTodo(@RequestBody TodoDto todoDto) {
		
		TodoDto savedTodoDto =todoServiceImpl.addToDo(todoDto);
		return new  ResponseEntity<>(savedTodoDto , HttpStatus.CREATED);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TodoDto>  getTodoById(@PathVariable("id") Long id) {
		
		TodoDto savedTodoDto =todoServiceImpl.getTodo(id);
		return new  ResponseEntity<>(savedTodoDto , HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<TodoDto>>  getAllTodoById() {
		
		List<TodoDto> savedTodoDto =todoServiceImpl.getAllTodo();
		return   ResponseEntity.ok(savedTodoDto);
		
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<TodoDto>  updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId  ) {
	TodoDto updateTodoDto =todoServiceImpl.updateTodo(todoDto, todoId);
		return   ResponseEntity.ok(updateTodoDto);
		
	} 
	
	@DeleteMapping("{id}")
	public ResponseEntity<String>  deleteTodo(@PathVariable("id") Long todoId  ) {
              todoServiceImpl.deleteTodo(todoId);
		return   ResponseEntity.ok("deleted successully");
		
	} 
	
	
	@PatchMapping("{id}/complete")
	public ResponseEntity<TodoDto>  completedTodo(@PathVariable("id") Long id) {
		
		TodoDto savedTodoDto =todoServiceImpl.CompletedTodo(id);
		return new  ResponseEntity<>(savedTodoDto , HttpStatus.OK);
		
	}
	
	@PatchMapping("{id}/in-complete")
	public ResponseEntity<TodoDto>  isCompletedTodo(@PathVariable("id") Long id) {
		
		TodoDto savedTodoDto =todoServiceImpl.isCompletedTodo(id);
		return new  ResponseEntity<>(savedTodoDto , HttpStatus.OK);
		
	}
	
	
	
	
	

}
