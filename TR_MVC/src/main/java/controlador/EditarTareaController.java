package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Empleado;
import modelo.EstadoTarea;
import modelo.Tarea;

@WebServlet("/EditarTareaController")
public class EditarTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarTareaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Obtener datos que envian en la solicitud
		Integer codeInteger = Integer.parseInt(request.getParameter("code"));
		String nombreTarea = (String) request.getParameter("name");

		// 2. Llamoar al modelo para obtener datos
		request.setAttribute("code", codeInteger);
		request.setAttribute("nombreTarea", nombreTarea);

		Empleado empleado = new Empleado();
		List<Empleado> empleados = empleado.getEmpleados();
		List<Empleado> empleadosFiltrados = new ArrayList<>();

		for (Empleado emp : empleados) {
			if (!"Luis".equals(emp.getNombre())) {
				empleadosFiltrados.add(emp);
			}
		}

		request.setAttribute("empleados", empleadosFiltrados);

		// 3. Llamar a la vista
		request.getRequestDispatcher("jsp/editarTarea.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Obtener datos que envian en la solicitud
		Integer code = Integer.parseInt(request.getParameter("code"));
		String nombre = request.getParameter("nombre");
		String responsable = request.getParameter("seleccion");
		// 2. Llamoar al modelo para obtener datos
		

		Tarea modeloTarea = new Tarea();
		List<Tarea> tareas = modeloTarea.getTareas();

		for (Tarea tarea : tareas) {
			if (tarea.getCode() == code) {
				tarea.setNombre(nombre);
				tarea.setResponsable(responsable);
				tarea.setEstado(EstadoTarea.TO_DO);
				modeloTarea.update(tarea);
				break;
			}
		}

		// 3. Llamar a la vista
		request.setAttribute("tareas", tareas);
		request.getRequestDispatcher("jsp/adminTareas.jsp").forward(request, response);
	}

}
