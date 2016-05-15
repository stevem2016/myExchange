package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletO
 */
@WebServlet("/ServletO")
public class ServletO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletO() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // grabs first and last from session attribs and converts to Cookie(s)
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String first = (String) session.getAttribute("first");
		String last = (String) session.getAttribute("last");
		out.println("First: " + first);
		out.println("Last: " + last);
		
		Cookie cookie = new Cookie("first", first);
		response.addCookie(cookie);
		cookie = new Cookie("last", last);
		response.addCookie(cookie);
		out.println("");
		out.println(">>> first and last saved in cookies");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
