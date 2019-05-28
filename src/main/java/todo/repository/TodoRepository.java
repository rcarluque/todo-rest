package todo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import todo.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String>{
	
	Todo getTodoById(String id);
	//Todo getTodoById(ObjectId id);
	
	void deleteTodoById(String id);
	//boolean deleteTodoById(ObjectId id);

}
