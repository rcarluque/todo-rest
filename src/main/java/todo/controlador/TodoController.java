package todo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import todo.model.Todo;
import todo.services.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api")
@Api
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	/**
	 * Método creado para las pruebas para eliminar todos lo registros e iniciar la BBDD con dos nuevos.
	 * @return
	 */
	@ApiOperation( value = "eliminar todos lo registros e inicia la BBDD con nuevos")
	@DeleteMapping("/resetTodos")
	public ResponseEntity<Void> resetTodos() {
		todoService.resetTodos();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<Todo>> getTodos() {
		return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/todo/{id}")
	public ResponseEntity<Todo> getTodoPath(@PathVariable("id") String id) {
		// TODO: implementar metodo si algun dia sirve
		return null;
	}
	
	@GetMapping("/todo")
	public ResponseEntity<Todo> getTodoHeader(@RequestHeader("id-todo") String id) {
		// TODO: implementar metodo si algun dia sirve
		return null;
	}
	
	@GetMapping("/?todo") // todo?id=abc
	public ResponseEntity<Todo> getTodoQuery(@RequestParam(name = "id") String todoId) {
		// También funciona sin aplicar propiedad 'name = id' si el param se llama igual que la variable
		// TODO: implementar metodo si algun dia sirve
		return null;
	}
	
	@ApiOperation( value = "Añadir un TODO")
	@PostMapping("/addTodo")
	public ResponseEntity<Todo> addTodo(@RequestBody String texto) {
		Todo t = todoService.addTodo(new Todo(texto));
		return new ResponseEntity<Todo>(t, HttpStatus.OK);
	}
	
	@ApiOperation( value = "Editar un TODO")
	@PutMapping("/todo/{id}")
	public ResponseEntity<Todo> editTodo(
		@ApiParam(value = "Id del todo a editar") 
		@PathVariable("id") String id, @RequestBody Todo todo
	) {
		return new ResponseEntity<Todo>(todoService.updateTodo(todo, id), HttpStatus.OK);
	}
	
    @ApiOperation(
            notes = "Método que elimina una Todo por su ID",
            value = "borrar Todo"
    )
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteTodo(@ApiParam("Todo id") @RequestParam("id") String id) {
    	todoService.deleteTodo(id);
    	return ResponseEntity.noContent().build();
	}

}
