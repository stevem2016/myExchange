package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletV2
 */
@WebServlet("/ServletV2")
public class ServletV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletV2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// generates a char[] for JSP from a form text field
		//String alpha_soup = "zpecawaqmtqyt";
		try {
		String alpha_soup = request.getParameter("alpha_soup");
		request.setAttribute("alpha_soup",alpha_soup.toCharArray());
		}
		catch (Exception ex) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Sorry, did not find alpha_soup parameter...");
			return;
		}


		getServletContext()
		    .getRequestDispatcher("/servletV2.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
