package todo.services;

import java.util.List;
import todo.model.Todo;

public interface TodoService {
	
	public abstract List<Todo> getAllTodos();
	
	public abstract Todo getTodo(String id);
	
	public abstract Todo addTodo(Todo todo);
	
	public abstract void deleteTodo(String id);
	
	public abstract Todo updateTodo(Todo todo, String id);
	
	public abstract void resetTodos();

}
