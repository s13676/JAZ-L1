package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

public class TestHelloServlet extends Mockito {
	@Test
	public void servlet_should_not_greet_the_user_if_name_is_null() throws IOException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		HelloServlet servlet = new HelloServlet();
		
		when(req.getParameter("name")).thenReturn(null);
		
		servlet.doPost(req, resp);
		
		verify(resp).sendRedirect("/");
	}
	@Test
	public void servlet_should_not_greet_the_user_if_name_is_empty() throws IOException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		HelloServlet servlet = new HelloServlet();
		
		when(req.getParameter("name")).thenReturn("");
		
		servlet.doPost(req, resp);
		
		verify(resp).sendRedirect("/");
	}
	@Test
	public void servlet_should_not_greet_the_user_if_name_is_provided() throws IOException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(req.getParameter("name")).thenReturn("jan");
		when(resp.getWriter()).thenReturn(writer);
		
		new HelloServlet().doPost(req, resp);
		
		verify(writer).println("<h1>Hello jan</h1>");
	}
}
