package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletL
 */
@WebServlet({"/ypath"} )
public class ServletL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SESSION_TTL = 60;
	private static final int NEW_VERSION = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletL() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // demonstrates cookie methods, esp. paths	
		Random rand = new Random();
		Cookie x_cookie = new Cookie("x" + rand.nextInt(1000), "x_cookie");
		x_cookie.setPath("/Java3/ypath");
		x_cookie.setMaxAge(SESSION_TTL/2); 
		//x_cookie.setDomain("google.com");
//		x_cookie.setSecure(true); 
		x_cookie.setVersion(NEW_VERSION);
		response.addCookie(x_cookie);

		Cookie y_cookie = new Cookie("y" + rand.nextInt(1000), "y_cookie");
		y_cookie.setPath("/Java3/ypath");
		y_cookie.setMaxAge(SESSION_TTL/2);
		response.addCookie(y_cookie);
		
		HttpSession session = request.getSession();
		session.setAttribute("id", session.getId());
		session.setAttribute("isNew", session.isNew());
		
		// what cookies came back?
		getServletContext()
		    .getRequestDispatcher("/session_K.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
