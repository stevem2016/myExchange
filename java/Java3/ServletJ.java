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
 * Servlet implementation class ServletJ
 */
@WebServlet("/ServletJ")
public class ServletJ extends HttpServlet {
	private static final int SESSION_TTL = 60;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJ() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Add a random cookie every time servlet called, 
		// but only lives half the session inactive time.
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(SESSION_TTL);  // session timeout
		session.setAttribute("id", session.getId());
		session.setAttribute("isNew", session.isNew());

		// add a random integer cookie to session
		Random rand = new Random();
		String cookie_key = "x" + Integer.valueOf(rand.nextInt(1000)).toString();
		System.out.println("Created cookie key: " + cookie_key);
		Cookie cookie = new Cookie(cookie_key, "random_number");
		cookie.setMaxAge(SESSION_TTL/2);  // expires halfway thru session
		cookie.setPath("/");
		response.addCookie(cookie);
		
		// pass control to JSP to build response
		this.getServletContext()
		              .getRequestDispatcher("/just_for_grins/session_A.jsp")
		              .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
