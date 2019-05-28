package todo.model;

//import java.io.Serializable;
//import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 @Document --> definir un nombre de una colección cuando el objeto se guarde en MongoDB.
 * @Document(collection = "users")
 @JsonPropertyOrder --> permite especificar el orden en que los campos del objeto java deberían ser serializados en JSON.
 * @JsonPropertyOrder({"userId", "name"})
 * @author rafael.carmona
 *
 */

@Document
public class Todo { //implements Serializable

	//private static final long serialVersionUID = -7788619177798333712L;
	
	@Id
	private String id;
	//private ObjectId _id;
	
	private String texto;
	private Boolean completado;
	
	public Todo() { }
		
	public Todo(String texto) {
		this.texto = texto;
		this.completado = false;
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Boolean isCompletado() {
		return completado;
	}

	public void setCompletado(Boolean completado) {
		this.completado = completado;
	}

}
