package chapter1.exercise;

import edu.princeton.cs.introcs.StdOut;

public class Ex1103 {
	public static void main(String[] args) {
		int first = Integer.parseInt(args[0]);
		int second = Integer.parseInt(args[1]);
		int third = Integer.parseInt(args[2]);

		if (first == second && second == third)
			StdOut.println("equal");
		else
			StdOut.println("not equal");
	}
}
