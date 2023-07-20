package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Empleado;
import modelo.Tarea;

@WebServlet("/AdminTareasController")
public class AdminTareasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminTareasController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Obtener datos que envian en la solicitud
		HttpSession session = request.getSession();
	    Empleado empleado = (Empleado) session.getAttribute("usuarioEmpleado");
	    String nombreUsuario = empleado.getNombre();
	    session.setAttribute("nombreUsuario", nombreUsuario) ;
		
				
		//2. Llamoar al modelo para obtener datos
		Tarea modeloTarea = new Tarea();
		List<Tarea> lista = modeloTarea.getTareas();
		
		//3. Llamar a la vista
		request.setAttribute("tareas", lista);
		request.getRequestDispatcher("jsp/adminTareas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
