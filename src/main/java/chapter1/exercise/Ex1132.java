package chapter1.exercise;

import chapter1.others.Interval;
import edu.princeton.cs.introcs.StdDraw;

public class Ex1132 {
	public static void main(String[] args) {
		/*
		 * 解析输入数据
		 */
		double[] inputs = { 1.0, 2.0, 3.1, 1.8, 4.5, 6.7, 3.2, 4.1, 9.0, 9.5 };
		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]);
		double r = Double.parseDouble(args[2]);

		/*
		 * 计算组距，确定出各组的界限值，最后得到频数分布表
		 */
		double groupInterval = (r - l) / N;
		Interval[] groups = new Interval[N]; // 各个组
		for (int i = 0; i < groups.length; i++) {
			double left = l + i * groupInterval;
			double right = l + (i + 1) * groupInterval;
			groups[i] = new Interval(left, right);
		}
		int[] groupCount = new int[N]; // 每个组对应的频数
		// 计算每个组对应的频数
		for (double input : inputs) {
			int groupNum = -1;
			for (int i = 0; i < groups.length; i++) {
				if (input >= groups[i].getLeft()
						&& input <= groups[i].getRight()) {
					groupNum = i;
					break;
				}
			}
			if (groupNum != -1) {
				groupCount[groupNum] = ++groupCount[groupNum];
			}
		}

		/*
		 * 画出直方图
		 */
		double radius = 10.0;
		StdDraw.setXscale(0, radius);
		StdDraw.setYscale(0, radius);
		for (int i = 0; i < groups.length; i++) {
			double left = groups[i].getLeft();
			double right = groups[i].getRight();
			int num = groupCount[i];
			StdDraw.filledRectangle((left + right) / 2, (double) num / 2, right
					- left / 2, (double) num / 2);
		}
	}
}
