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
@WebServlet("/LottoServletB")
public class LottoServletB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LottoServletB() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int num_lotto_balls;
		int max_ball_num;
		int simulation_years;

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		try {
		    num_lotto_balls = Integer.parseInt(request.getParameter("num_lotto_balls"));
		    max_ball_num = Integer.parseInt(request.getParameter("max_ball_number"));
		    simulation_years = Integer.parseInt(request.getParameter("years"));
		    // could do some sanity checks here...
		}
		catch (Exception ex) {
            out.println("Please check your parameters and retry");	
            return;
		}

		Lotto lotto = new Lotto();
		// lotto needs the output stream and form inputs
		lotto.setOut(out);  
		lotto.setNum_lotto_balls(num_lotto_balls);
		lotto.setMax_ball_num(max_ball_num);
		lotto.setSimulation_years(simulation_years);
		
		out.println("\nThe odds are 1 in " + lotto.calc_odds()
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
