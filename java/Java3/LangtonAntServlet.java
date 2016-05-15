package edu.acc.java;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LangtonAntServlet
 */
@WebServlet("/LangtonAntServlet")
public class LangtonAntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LangtonAntServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		// get required parameters from form
		int latticeSize;
		int[] viewStops;
		int[] startRowCol;

		try {
			String p1 = request.getParameter("latticeSize");
			if (p1 == null) {
				p1 = "60";
			}
			latticeSize = Integer.parseInt(p1);

			String p2 = request.getParameter("viewStops");
			if (p2 == null) {
				p2 = "18,180,18000";
			}
			String[] vs = p2.split(",");
			viewStops = new int[vs.length];
			for (int i = 0; i < vs.length; i++) {
				viewStops[i] = Integer.parseInt(vs[i]);
			}

			String p3 = request.getParameter("startRowCol");
			if (p3 == null) {
				p3 = "40,40";
			}
			String[] rc = p3.split(",");
			startRowCol = new int[rc.length];
			for (int i = 0; i < rc.length; i++) {
				startRowCol[i] = Integer.parseInt(rc[i]) - 1;
			}

		} catch (Exception ex) {
			out.println("\nSorry, incorrect input...please re-run");
			return;
		}

		// create the Langton Ant
		LangtonAnt ant = new LangtonAnt(latticeSize, viewStops, startRowCol);
		ant.init();
		ant.run(); // see ant run. run ant run! see ant go to infinity
		LangtonCell[][] lattice = ant.getLattice();
		request.setAttribute("lattice", lattice);
		request.setAttribute("latticeSize", latticeSize);
		request.setAttribute("iteration", ant.getIteration());
		
		this.getServletContext().
		    getRequestDispatcher("/langtonAnt.jsp").
		    forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
