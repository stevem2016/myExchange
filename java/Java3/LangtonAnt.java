package edu.acc.java;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Java3 Final Project
 * 1. Review Langton's Ant at https://en.wikipedia.org/wiki/Langton's_ant 
 * 
 * 2. Implement Langton's Ant as a POJO. Are any other classes necessary? 
 *    With an all-black square lattice size of 11 and starting position of (7,6) 
 *    Print the lattice to the console after 18 moves, 180 moves, and 18000 moves 
 *    using “W” for white cells, “B” for black cells, and “A” for the ant. 
 *    Ant is facing toward top of lattice to start. If the ant tries to get 
 *    outside the lattice, print the lattice at that point and exit. 
 *    Experiment with different lattice sizes and starting points.
 *    
 * 3. Convert the Langton Ant POJO into servlet form. 
 *    Use a form to enter the lattice size, starting location, and move count 
 *    to visually inspect lattice (view stops). Use a JSP to print the lattice.
 *    
 * 4. (stretch goal) Detect at what move count the ant converges and print to 
 *    the client when it occurs.
 *    
 * @author pi
 *
 */
public class LangtonAnt {

	private LangtonCell[][] lattice; // movement surface
	private PrintStream out = System.out;
	private LANGTON_COLOR initial_lattice_color = LANGTON_COLOR.BLACK;
	private int latticeSize; // default length of lattice side
	private int[] viewStops; // iteration counts to print
	private int[] startRowCol; // default start row and column
	private long iteration = 0; // current iteration number
	private int curr_x; // current ant x
	private int curr_y; // current ant y
	private LANGTON_COMPASS curr_direction; // current ant direction
	private boolean isServlet;  // running under a servlet?

	public static void main(String... args) {
		LangtonAnt ant = new LangtonAnt();
		ant.init();
		ant.run(); // see ant run. run ant run! see ant go to infinity
	}
	
	public LangtonCell[][] getLattice() {
		return lattice;
	}

	public long getIteration() {
		return iteration;
	}

	public void setLattice(LangtonCell[][] lattice) {
		this.lattice = lattice;
	}
	/**
	 * Constructor for use by servlet
	 * 
	 * @param latticeSize
	 * @param viewStops
	 * @param startRowCol
	 */
	public LangtonAnt(int latticeSize, int[] viewStops, int[] startRowCol) {
		this.latticeSize = latticeSize;
		this.startRowCol = startRowCol;
		this.viewStops = viewStops;
		this.isServlet = true;
	}

	/**
	 * Main loop to move ant
	 */
	public void run() {
		// iterate the lattice through stop points
		for (int nextStop : viewStops) {
			// move ant and snapshot the lattice if necessary
			try {
				while (++iteration < nextStop) {
					move_ant();
				}
				snapShot();  // snapshot to console at each view stop
			} catch (Exception ex) {
				out.println("\n" + ex);
//				ex.printStackTrace(out);  // debugging
				return;
			}
		}
	}

	/**
	 Move ant once per Langton rules:
	 - at a white cell, turn 90° right, flip the color, move forward one unit
	 - at a black cell, turn 90° left, flip the color, move forward one unit
	 * 
	 * @throws Exception
	 */
	private void move_ant() throws Exception {

		lattice[curr_x][curr_y].setAntPresent(false); // ant is moving
		LANGTON_COLOR color = lattice[curr_x][curr_y].getColor();

		if (color.equals(LANGTON_COLOR.BLACK)) {
			// flip the color
			lattice[curr_x][curr_y].setColor(LANGTON_COLOR.WHITE);
			// turn left and move forward 1
			switch (curr_direction) {
			case NORTH:
				curr_direction = LANGTON_COMPASS.WEST;
				curr_x--; // proceed WEST
				break;
			case WEST:
				curr_direction = LANGTON_COMPASS.SOUTH;
				curr_y--; // proceed SOUTH
				break;
			case SOUTH:
				curr_direction = LANGTON_COMPASS.EAST;
				curr_x++; // proceed EAST
				break;
			case EAST:
				curr_direction = LANGTON_COMPASS.NORTH;
				curr_y++; // proceed NORTH
			}
		} else if (color.equals(LANGTON_COLOR.WHITE)) {
			// flip the color
			lattice[curr_x][curr_y].setColor(LANGTON_COLOR.BLACK);
			// turn right and move forward 1
			switch (curr_direction) {
			case NORTH:
				curr_direction = LANGTON_COMPASS.EAST;
				curr_x++; // proceed EAST
				break;
			case WEST:
				curr_direction = LANGTON_COMPASS.NORTH;
				curr_y++; // proceed NORTH
				break;
			case SOUTH:
				curr_direction = LANGTON_COMPASS.WEST;
				curr_x--; // proceed WEST
				break;
			case EAST:
				curr_direction = LANGTON_COMPASS.SOUTH;
				curr_y--; // proceed SOUTH
			}
		} else {
			throw new Exception("Invalid LANGTON_COLOR");
		}
		
		// enforce the lattice boundary
		if (curr_x < 0 || curr_x >= latticeSize ||
		    curr_y < 0 || curr_y >= latticeSize) {
			snapShot();
			throw new Exception("Out of bounds");
		}

		// mark new ant location
		lattice[curr_x][curr_y].setAntPresent(true);
	}

	/**
	 * Print lattice
	 * 
	 * @throws Exception
	 */
	public void snapShot() throws Exception {
		//if (isServlet) return;  // only for non-servlet use
		out.println("\n\nsnapshot @ " + iteration);
		for (int i = 0; i < latticeSize; i++) {
			out.println();
			for (int j = 0; j < latticeSize; j++) {
				LangtonCell cell = lattice[i][j];
				LANGTON_COLOR color = cell.getColor();
				String glyph = "";
				switch (color) {
				case BLACK:
					glyph = "B";
					break;
				case WHITE:
					glyph = " ";
					break;
				default:
					throw new Exception("Invalid LANGTON_COLOR");
				}
				if (cell.isAntPresent()) {
					glyph = "A";
				}
				out.print(glyph);
			}
		}
	}

	/**
	 * Constructor used by non-servlets
	 */
	public LangtonAnt() {
		Scanner console = new Scanner(System.in);
		boolean ok = false;
		do {
			try {
				out.print("\nEnter lattice size (min 3): ");
				latticeSize = console.nextInt();
				out.print("\nEnter integer view stops separated by commas: ");
				String[] viewStops = (console.next()).split(",");
				this.viewStops = new int[viewStops.length];
				for (int i = 0; i < viewStops.length; i++) {
					this.viewStops[i] = Integer.parseInt(viewStops[i]);
				}
				out.print("\nEnter starting row and column separated by commas: ");
				String[] startRowCol = (console.next()).split(",");
				this.startRowCol = new int[startRowCol.length];
				for (int i = 0; i < startRowCol.length; i++) {
					this.startRowCol[i] = Integer.parseInt(startRowCol[i]) - 1;
				}
				ok = true; // made it
			} catch (Exception ex) {
				out.println("\nSorry, incorrect input...please retry");
			}
		} while (!ok);
	}

	/**
	 * initialization for servlet and non-servlet use
	 */
	public void init() {
		lattice = new LangtonCell[latticeSize][latticeSize];
		for (int i = 0; i < latticeSize; i++) {
			for (int j = 0; j < latticeSize; j++) {
				lattice[i][j] = new LangtonCell(initial_lattice_color);
			}
		}
		curr_x = startRowCol[0]; // initial ant x
		curr_y = startRowCol[1]; // initial ant y
		lattice[curr_x][curr_y].setAntPresent(true);  // mark ant present
		curr_direction = LANGTON_COMPASS.NORTH; // initial ant direction
	}

}
