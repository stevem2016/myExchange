package edu.acc.java;
import edu.acc.java.RandZ;

public interface ShapeOps {
    // All shapes must implement this contract
	
	public float area();  // computes area of this
	public float circumference();  // computes circumference of this
	public ShapeBase.SHAPE type();  // returns type as a SHAPE enum
	public RandZ random_z();  // returns a RandZ enum integer
}
