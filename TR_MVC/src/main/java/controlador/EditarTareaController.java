package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Empleado;
import modelo.Tarea;

@WebServlet("/EditarTareaController")
public class EditarTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarTareaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Obtener datos que envian en la solicitud
		Integer codeInteger = Integer.parseInt(request.getParameter("code"));
		String nombreTarea = (String) request.getParameter("name");
		
		//2. Llamoar al modelo para obtener datos
		request.setAttribute("code", codeInteger);
		request.setAttribute("nombreTarea", nombreTarea);
		
		Empleado empleado = new Empleado();
		List<Empleado> empleados = empleado.getEmpleados();
		
		Empleado empleadoEliminar = null;
		for (Empleado emp : empleados) {
		    if ("Luis".equals(emp.getNombre())) {
		        empleadoEliminar = emp;
		        break;
		    }
		}
		// Verificar si se encontró el empleado
		if (empleadoEliminar != null) {
		    empleados.remove(empleadoEliminar);
		}	
		
		request.setAttribute("empleados", empleados);
					
		//3. Llamar a la vista
		request.getRequestDispatcher("jsp/editarTarea.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Obtener datos que envian en la solicitud
		Integer code = Integer.parseInt(request.getParameter("code"));
		String nombre = request.getParameter("nombre");
		String responsable = request.getParameter("seleccion");
		
		//2. Llamoar al modelo para obtener datos
		Tarea modeloTarea = new Tarea();
		List<Tarea> tareas = modeloTarea.getTareas();
		
		for (Tarea tarea : tareas) {
			if (tarea.getCode() == code) {
				tarea.setNombre(nombre);
				tarea.setResponsable(responsable);
				tarea.setEstado("To do");
				break;
			}
		}
					
		//3. Llamar a la vista
		request.setAttribute("tareas", tareas);
		request.getRequestDispatcher("jsp/adminTareas.jsp").forward(request, response);
	}

}
