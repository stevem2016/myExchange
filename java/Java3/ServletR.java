package edu.acc.java;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletR
 */
@WebServlet("/ServletR")
public class ServletR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletR() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// creates Hashtable of java beans for JSP to consume
		Hashtable<String, SkyBean> skyMap = new Hashtable<>();
		skyMap.put("Weisbaden", new SkyBean());
		skyMap.put("Singapore", new SkyBean());
		skyMap.put("Cayman", new SkyBean());
		skyMap.put("Paris", new SkyBean());
	    
		HttpSession session = request.getSession();
		session.setAttribute("skyMap", skyMap);
		
		getServletContext()
		    .getRequestDispatcher("/servletR.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
