package chapter1.others;


public class Test {
	public static int mystery(int a, int b) {
		if (b == 0)
			return 1;
		if (b % 2 == 0)
			return mystery(a * a, b / 2);
		return mystery(a * a, b / 2) * a;
	}

	public static String exR1(int n) {
		if (n <= 0)
			return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}

	public static String exR2(int n) {
		String s = exR2(n - 3) + n + exR2(n - 2) + n;
		if (n <= 0)
			return "";
		return s;
	}

	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		double t = 9.0;
//		while (Math.abs(t-9.0/t)>.001)
//			t=(9.0/t+t)/2.0;
//		StdOut.printf("%.5f\n", t);
		
//		int sum = 0;
//		for (int i=1;i<1000;i++)
//			for (int j=0;j<i;j++)
//				sum++;
//		StdOut.println(sum);
		
//		int sum=0;
//		for (int i=1;i<1000;i*=2)
//			for (int j=0;j<1000;j++)
//				sum++;
//		StdOut.println(sum);
		
//		System.out.println((char)('a'+4));
		
//		int[] a = new int[10];
//		for (int i=0;i<10;i++)
//			a[i]=9-i;
//		for (int i=0;i<10;i++)
//			a[i]=a[a[i]];
//		for (int i=0;i<10;i++)
//			System.out.println(i);
		
//		System.out.println(exR1(6));
		
		System.out.println(mystery(3, 11));
	}
}
