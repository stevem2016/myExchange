package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletX
 */
public class ServletX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletX() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Shows initialization parms received
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Context Parms</h2>");
		out.println("<p>All servlets see: " + this
				                              .getServletContext()
				                              .getInitParameter("universal_parm"));
		out.println("<p>My servlet sees: " + this
				                              .getServletConfig()
				                              .getInitParameter("my_parm"));
		out.println("</body></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
