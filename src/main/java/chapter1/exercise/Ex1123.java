package chapter1.exercise;

import java.util.Arrays;

import chapter1.algorithm.BinarySearch;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Ex1123 {
	/**
	 * args[0]为白名单文件的路径，args[1]为"+"或"-"
	 * 
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			int exists = BinarySearch.rank(key, whitelist);
			if (args[1].equals("+")) {
				if (exists == -1)
					StdOut.println(key);
			} else {
				if (exists != -1)
					StdOut.println(key);
			}
		}
	}
}
