package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer code;
	private String nombre;
	private String responsable;
	private String estado;
	
	private static List<Tarea> tareas = new ArrayList<>();
	
	// CONSTRUCTORS
	
	public Tarea() {
	}

	public Tarea(Integer code, String nombre, String estado) {
		super();
		this.code = code;
		this.nombre = nombre;
		this.responsable = "";
		this.estado = estado;
	}

	// GETTERS - SETTERS
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	// BUSINESS RULES
	
	public List<Tarea> getTareas() {
		return tareas;
	}
	
	public void crearTarea(Tarea t) {
		this.getTareas().add(t);
	}
	
	public void cabiarEstado() {
		
	}
	
	
	
	
	
}
