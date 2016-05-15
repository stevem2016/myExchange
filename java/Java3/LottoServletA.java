package edu.acc.java;

import edu.acc.java.lotto.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LottoServletA
 */
@WebServlet("/LottoServletA")
public class LottoServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LottoServletA() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		Lotto lotto = new Lotto();
		lotto.setOut(out);  // lotto needs the output stream

		System.out.println("\nThe odds are 1 in " + lotto.calc_odds()
				+ " using " + lotto.getNum_lotto_balls() + " balls and "
				+ lotto.getMax_ball_num() + " ball numbers");

		// run a simulation
		lotto.setSimulator(new LotteryDrawing(
				lotto.getNum_lotto_balls(), 
				lotto.getMax_ball_num(), 
				lotto.getSimulation_years()));
		lotto.getSimulator().run_simulation();
		lotto.print_results();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
