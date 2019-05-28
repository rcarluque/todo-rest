package todo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.model.Todo;
import todo.repository.TodoRepository;
import todo.services.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}
	
	public Todo getTodo(String id) {
		return todoRepository.getTodoById(id);
	}
	
	@Override
	public Todo addTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	@Override
	public void deleteTodo(String id) {
		todoRepository.deleteTodoById(id);
	}
	
	@Override
	public Todo updateTodo(Todo todoNuevo, String id) {
		Todo todo = getTodo(id);
		
		if (todoNuevo.getTexto() != null) {
			todo.setTexto(todoNuevo.getTexto());
		} else if (todoNuevo.isCompletado() != null) {
			todo.setCompletado(todoNuevo.isCompletado());
		}
		
		return todoRepository.save(todo);
	}
	
	@Override
	public void resetTodos() {
		todoRepository.deleteAll();
		addTodo(new Todo("Comprar leche"));
		addTodo(new Todo("Comprar Comprar pan"));
	}

}
