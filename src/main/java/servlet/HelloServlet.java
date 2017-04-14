package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		
		if (name == null || name.equals("")) {
			resp.sendRedirect("/");
			return;
		}
		
		resp.setContentType("text/html");
		resp.getWriter().println("<h1>Hello " + name + "</h1>");
	}
}
