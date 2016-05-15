package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFirstLastName
 */
@WebServlet("/ServletFirstLastName")
public class ServletFirstLastName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletFirstLastName() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// System.out.println("Whoops...wrong method used on form");
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		if (first_name == null) {
			out.println("First name not received...check form");
			return;
		}
		if (last_name == null) {
			out.println("Last name not received...check form");
			return;
		}
//		out.println("<br>" + first_name + " " + last_name);
		request.setAttribute("first", first_name);
		request.setAttribute("last", last_name);
//		response.sendRedirect("http://www.google.com");
		 this.getServletContext()
		 .getRequestDispatcher("/PrintNames")
		 .forward(request, response);
//		 .getRequestDispatcher("/echo_names.jsp")
//		 .forward(request, response);
	}

}
