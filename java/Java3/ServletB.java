package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletB
 */
@WebServlet(
		description = "Ex.2 ", 
		urlPatterns = { 
				"/ServletB", 
				"/appB"
		})
public class ServletB extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletB() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Exercises a number of request object methods
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>");
		out.println("Selected request fields:");
		out.println("<br>Authtype : " + request.getAuthType());
		out.println("<br>ContextPath : " + request.getContextPath());
		out.println("<br>Local name : " + request.getLocalName());
		out.println("<br>Local port : " + request.getLocalPort());
		out.println("<br>Method : " + request.getMethod());
		out.println("<br>Protocol : " + request.getProtocol());
		out.println("<br>Query string : " + request.getQueryString());
		out.println("<br>Remote address : " + request.getRemoteAddr());
		out.println("<br>Remote host : " + request.getRemoteHost());
		out.println("<br>Remote port : " + request.getRemotePort());
		out.println("<br>Requested session id : " + request.getRequestedSessionId());
		out.println("<br>Request URI : " + request.getRequestURI());
		out.println("<br>Request scheme : " + request.getScheme());
		out.println("<br>Server name : " + request.getServerName());
		out.println("<br>Server port : " + request.getServerPort());
		out.println("<br>Servlet path : " + request.getServletPath());
		out.println("<br>Dispather type : " + request.getDispatcherType());
		out.println("<br>Locale : " + request.getLocale());
		out.println("<br>Request URL : " + request.getRequestURL());
		out.println("<br>Servlet Context : " + request.getServletContext());
		out.println("<br>Session : " + request.getSession());

		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
