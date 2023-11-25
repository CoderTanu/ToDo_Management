package com.CoderTanu.todo.service;

import java.util.List;

import com.CoderTanu.todo.dto.TodoDto;


public interface TodoService {
	

    //add todo in db
	TodoDto addToDo(TodoDto todoDto);
	
	//get by using id from db
	TodoDto getTodo(Long id);
	
	//getAll todo list which present in db
	List<TodoDto> getAllTodo();
	  
	
	//update Todo
	TodoDto updateTodo(TodoDto todoDto,Long id);
	
	//delete todo
	void deleteTodo(Long id);
	TodoDto CompletedTodo(Long id);
	
	TodoDto isCompletedTodo(Long id);
	
	
	

}
