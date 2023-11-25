package com.CoderTanu.todo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.CoderTanu.todo.dto.TodoDto;
import com.CoderTanu.todo.entity.Todo;
import com.CoderTanu.todo.exception.ResourcsNotFoundException;
import com.CoderTanu.todo.repo.TodoRepo;
import com.CoderTanu.todo.service.TodoService;



@Service	
public class TodoServiceImpl  implements TodoService{

	 
	 private TodoRepo todoRepo;
    private ModelMapper modelMapper;

	public TodoServiceImpl(TodoRepo todoRepo, ModelMapper modelMapper) {
			this.todoRepo = todoRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public TodoDto addToDo(TodoDto todoDto) {
		//convert todo DTO to todo jpa  
		//Todo todo = new Todo();
		
//		todo.setId(todoDto.getId());
//		todo.setTitle(todoDto.getTitle());
//		todo.setDescription(todoDto.getDescription());
//		todo.setCompleted(todoDto.isCompleted());
		
		
		//todo jpa entity saved in db 
		//Todo  savedTodo =todoRepo.save(todo);
		
//		TodoDto savedTodoDto = new TodoDto();
//		
//		savedTodoDto.setId(savedTodo.getId());
//		savedTodoDto.setTitle(savedTodo.getTitle());
//		savedTodoDto.setDescription(savedTodo.getDescription());
//		savedTodoDto.setCompleted(savedTodo.isCompleted());
//		
		Todo  todo=modelMapper.map(todoDto, Todo.class);
		Todo  savedTodo =todoRepo.save(todo);
		TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);
		return savedTodoDto;
	}

	@Override
	public TodoDto getTodo(Long id) {
		Todo todo =todoRepo.findById(id).orElseThrow(()-> new ResourcsNotFoundException("Todo is not found with id " + id));
		TodoDto savedTodoDto = modelMapper.map(todo, TodoDto.class);
		return savedTodoDto;
	}

	@Override
	public List<TodoDto> getAllTodo() {
		List<Todo> todoList =todoRepo.findAll();
	return todoList.stream().map((todo)->modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());

	}

	@Override
	public TodoDto updateTodo(TodoDto todoDto, Long id) {
		Todo todo =todoRepo.findById(id).orElseThrow(()-> new ResourcsNotFoundException("Todo is not found with id " + id));
		todo.setTitle(todoDto.getTitle());
		todo.setDescription(todoDto.getDescription());
		todo.setCompleted(todoDto.isCompleted());	
		Todo updateTodo = todoRepo.save(todo);
		return modelMapper.map(updateTodo, TodoDto.class);
	}

	@Override
	public void deleteTodo(Long id) {
		Todo todo =todoRepo.findById(id).orElseThrow(()->new ResourcsNotFoundException("Todo is not found with id " + id));
		todoRepo.deleteById(id);

	}

	@Override
	public TodoDto CompletedTodo(Long id) {
		
		Todo todo =todoRepo.findById(id).orElseThrow(()->new ResourcsNotFoundException("Todo is not found with id " + id));
		todo.setCompleted(Boolean.TRUE);
		Todo updateTodo= todoRepo.save(todo);
		return modelMapper.map(updateTodo, TodoDto.class);
	}

	@Override
	public TodoDto isCompletedTodo(Long id) {
	
		Todo todo =todoRepo.findById(id).orElseThrow(()->new ResourcsNotFoundException("Todo is not found with id " + id));
		todo.setCompleted(Boolean.FALSE);
		Todo updateTodo= todoRepo.save(todo);
		return modelMapper.map(updateTodo, TodoDto.class);
	}

	


}
