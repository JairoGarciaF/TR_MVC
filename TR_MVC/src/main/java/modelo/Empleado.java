package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String password;
	private String area;
	
	private static List<Empleado> empleados = null;
	
	// CONSTRUCTORS
	public Empleado() {
	}

	public Empleado(Integer id, String nombre, String password, String area) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.area = area;
	}
	
	// GETTERs - SETTERS
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	// BUSINESS RULES
	
	public List<Empleado> getEmpleados(){
		if (empleados == null) {
			empleados = new ArrayList<>();

			empleados.add(new Empleado(1, "Luis", "luis123", "Direccion TH"));
			empleados.add(new Empleado(2, "Pepe", "pepe123", "Pago de Salarios"));
			empleados.add(new Empleado(3, "Maria", "maria123", "Becas y estimulos"));
			empleados.add(new Empleado(4, "Mariana", "mariana123", "Salud Laboral"));
		}
		return empleados;
	}
	
	public Empleado autorizar(String usuario, String password) {
		Empleado empleadoAutorizado = null;
		List<Empleado> listaEmpleados = this.getEmpleados();
		for (Empleado empleado : listaEmpleados) {
			if (empleado.getNombre().equals(usuario) && empleado.getPassword().equals(password)) {
				empleadoAutorizado = empleado;
				break;
			}
		}
		
		return empleadoAutorizado;
	}
	
}
