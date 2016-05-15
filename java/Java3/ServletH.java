package edu.acc.java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletH
 */
@WebServlet("/ServletH")
public class ServletH extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SESSION_TTL = 60; // Session Time To Live
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletH() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// basic session calls and JSP to view results
		System.out.println("ServletH here");
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(SESSION_TTL);  // 1 min session timeout
		session.setAttribute("id", session.getId());
		session.setAttribute("xnew", session.isNew());

		this.getServletContext()
        .getRequestDispatcher("/just_for_grins/session_J.jsp")
        .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
