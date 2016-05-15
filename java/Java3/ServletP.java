package edu.acc.java;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletP
 */
@WebServlet("/ServletP")
public class ServletP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletP() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read cookies for name and put in request attribs
		Map<String, String> cookieMap = cookiesToMap(request);
	    String first = cookieMap.get("first");
	    request.setAttribute("xfirst", first);
	    String last = cookieMap.get("last");
	    request.setAttribute("xlast", last);
		
	    // View
		getServletContext()
		    .getRequestDispatcher("/servletP.jsp")
		    .forward(request,  response);
	}
	
	/**
	 * Converts cookie array to a Map
	 * @param request object 
	 * @return map
	 */
	public Map<String, String> cookiesToMap(HttpServletRequest request) {
		Map<String, String> map = new Hashtable<>();
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			map.put(c.getName(), c.getValue());
		}
		return map;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
