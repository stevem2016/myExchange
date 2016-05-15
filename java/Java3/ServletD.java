package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation 
 */
@WebServlet(
		description = "Ex.4 ", 
		urlPatterns = { 
				"/ServletD", 
				"/appD"
		})
public class ServletD extends HttpServlet {
	private static final long serialVersionUID = 3L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletD() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Similar to ServletC but uses a jsp instead of PrintWriter to output response
		String host = request.getHeader("host");
		request.setAttribute("host", host);
		String user_agent = request.getHeader("user-agent");
		request.setAttribute("user_agent", user_agent);
		String accept = request.getHeader("accept");
		request.setAttribute("accept", accept);
		request.setAttribute("my_name", "Manus Martian");

		this.getServletContext()
		    .getRequestDispatcher("/request_header_table.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
