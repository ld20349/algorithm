package chapter1.exercise;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import edu.princeton.cs.introcs.StdOut;

public class Ex1121 {
	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(new File(Ex1121.class
				.getResource("Ex1121.txt").getPath()));
		for (String line : lines) {
			String[] columns = line.split("\\t");
			String name = columns[0];
			int firstInt = Integer.parseInt(columns[1]);
			int secondInt = Integer.parseInt(columns[2]);
			StdOut.printf("%10s\t%5d\t%5d\t%.3f\n", name, firstInt, secondInt,
					(double) firstInt / secondInt);
		}
	}
}
