package chapter1.exercise;

import edu.princeton.cs.introcs.StdOut;

public class Ex1105 {
	public static void main(String[] args) {
		double x = -0.1;
		double y = 0.43;
		if ((x > 0 && x < 1) && (y > 0 && y < 1))
			StdOut.println(true);
		else
			StdOut.println(false);
	}
}
