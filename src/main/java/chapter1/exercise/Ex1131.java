package chapter1.exercise;

import chapter1.others.Point;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

public class Ex1131 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);

		double r = 100.0;
		StdDraw.setXscale(-r, r);
		StdDraw.setYscale(-r, r);
		StdDraw.circle(0.0, 0.0, r);
		Point[] points = new Point[N];
		for (int i = 0; i < points.length; i++) {
			double angle = 0.0 + i * 2 * Math.PI / N;
			points[i] = new Point(Math.cos(angle) * r, Math.sin(angle) * r);
		}
		for (Point point : points) {
			StdDraw.setPenRadius(0.05);
			StdDraw.point(point.getX(), point.getY());
		}
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if (StdRandom.random() < p) {
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.line(points[i].getX(), points[i].getY(),
							points[j].getX(), points[j].getY());
				}
			}
		}
	}

}
