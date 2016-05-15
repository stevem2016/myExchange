package edu.acc.java;

/**
 * Represents each Langton cell in a lattice
 * 
 * @author pi
 *
 */
public class LangtonCell {
	private LANGTON_COLOR color;  
	private int visits = 0;  // counts number of times this cell visited
	private boolean antPresent = false;
	
public LangtonCell(LANGTON_COLOR color) {
	this.color = color;
    }

public LANGTON_COLOR getColor() {
	return color;
}

public void setColor(LANGTON_COLOR color) {
	this.color = color;
}

public int getVisits() {
	return visits;
}

public void setVisits(int visits) {
	this.visits = visits;
}

public boolean isAntPresent() {
	return antPresent;
}

public void setAntPresent(boolean antPresent) {
	this.antPresent = antPresent;
}
}
