package edu.acc.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletJCBean
 */
@WebServlet("/ServletJCBean")
public class ServletJCBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SESSION_TTL = 60;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletJCBean() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Add a random cookie every time servlet called,
		// but only lives half the session inactive time.
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(SESSION_TTL);
		session.setAttribute("id", session.getId());
		session.setAttribute("isNew", session.isNew());

		// throw a random cookie to the client to come back NEXT time
		Random rand = new Random();
		String cookie_key = "x"
				+ Integer.valueOf(rand.nextInt(1000) + 1).toString();
		System.out.println("Created cookie key: " + cookie_key);
		Cookie cookie = new Cookie(cookie_key, "random_number");
		cookie.setMaxAge(SESSION_TTL / 2); // expire before session
//		cookie.setMaxAge(SESSION_TTL * 2); // expire after session
		cookie.setPath("/");  // send back to any servlet on the server
		response.addCookie(cookie);  // send when this method ends

		// what cookies came back on THIS request?
		Cookie[] request_cookies = request.getCookies();

		// store each cookie in a javabean
		List<CookieBean> cookie_collection = new ArrayList<>();
		for (Cookie c : request_cookies) {
			CookieBean cb = new CookieBean(c.getName(), c.getValue());
			cookie_collection.add(cb);
		}
		
		// collection built...make available to JSP via the session
		session.setAttribute("cc", cookie_collection);
		
		// let JSP build response
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/servletJCBean.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sorry,use HTTP GET verb");
	}

}
