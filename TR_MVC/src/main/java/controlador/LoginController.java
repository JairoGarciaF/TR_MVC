package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Empleado;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Obtener datos que envian en la solicitud
		
		//2. Llamoar al modelo para obtener datos
				
		//3. Llamar a la vista
		response.sendRedirect("jsp/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Obtener datos que envian en la solicitud
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		//2. Llamoar al modelo para obtener datos
		
		Empleado modeloEmpleado = new Empleado();
		Empleado empleadoAutenticado = modeloEmpleado.autorizar(usuario, password);
		
		if (empleadoAutenticado != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioEmpleado", empleadoAutenticado);
			
			if (empleadoAutenticado.getArea().equals("Direccion TH")) {
				//3. Llamar a la vista
				response.sendRedirect("AdminTareasController");
			}else {
				//3. Llamar a la vista
				response.sendRedirect("ListarTareaController");
			}
			return;
		}else {
			//3. Llamar a la vista
			String mensaje = "Ingresaste  mal tu usuario o clave";
			//Enviar datos a la vista
			request.setAttribute("mensaje", mensaje);
			//Redireccionar a la vista
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
				
		
	}

}
