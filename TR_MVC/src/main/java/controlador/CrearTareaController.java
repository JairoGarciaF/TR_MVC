package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.EstadoTarea;
import modelo.Tarea;

@WebServlet("/CrearTareaController")
public class CrearTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CrearTareaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Obtener datos que envian en la solicitud
		
		
		//2. Llamoar al modelo para obtener datos
			
			
		//3. Llamar a la vista
		response.sendRedirect("jsp/crearTarea.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Obtener datos que envian en la solicitud
				String nombre = request.getParameter("nombre");
			
								
				//2. Llamoar al modelo para obtener datos
				
				if (nombre != "") {
					
					Tarea tarea = new Tarea();
					
					tarea.setNombre(nombre);
					tarea.setResponsable("");
					tarea.setEstado(EstadoTarea.TO_ASSIGN);
					
					Tarea modeloTarea = new Tarea();
					modeloTarea.crearTarea(tarea);
					List<Tarea> lista = modeloTarea.getTareas();
					//3. Llamar a la vista
					request.setAttribute("tareas", lista);
					request.getRequestDispatcher("jsp/adminTareas.jsp").forward(request, response);
					
				}else {
					response.sendRedirect("CrearTareaController");
				}
	}

}
