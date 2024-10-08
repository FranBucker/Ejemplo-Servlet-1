package ejemplos.servlet.curso;

import jdk.vm.ci.meta.Local;
import sun.util.calendar.BaseCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/myServlet2")
public class MyServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String nombreForm = request.getParameter("nombre");
		String apellidoForm = request.getParameter("apellido");
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fechaHoraFormateada = fechaHoraActual.format(formato);
		request.setAttribute("nombreJSP", nombreForm);
		request.setAttribute("apellidoJSP", apellidoForm);
		request.setAttribute("fechaJSP", fechaHoraFormateada);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bienvenida.jsp");

		dispatcher.forward(request, response);
	}

}
