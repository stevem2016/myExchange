package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCBootstrapLocal
 */
@WebServlet("/ServletCBootstrapLocal")
public class ServletCBootstrapLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCBootstrapLocal() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Outputs all request headers to a Bootstrap formatted table
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/*
		 * Note: there's a better way (JSP's) but for now...
		 */
		out.println("<!DOCTYPE html><html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		// use bootstrap, mobile-ready
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");  
		out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
		out.println("</head><body>");
		out.println("<table class=\"table table-hover\">");
		out.println("<thead>");
		out.println("<tr><th>Key</th><th>Value</th></tr>");
		out.println("</thead>");
		out.println("<tbody>");

		// dump out all the headers in a table
		Enumeration<String> hdr_names = request.getHeaderNames();  // get all the HTTP header keys
		while (hdr_names.hasMoreElements()) {
			String key =  hdr_names.nextElement();
			String val =  request.getHeader(key);
			out.println("<tr><td>" + key + "</td><td>" + val + "</td></tr>");
		}

		out.println("</tbody>");
		out.println("</table>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
