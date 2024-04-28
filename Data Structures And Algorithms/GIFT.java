import java.util.*;

class GIFT {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[m];

		for (int i = 0; i < a.length; i++)
			a[i] = sc.nextInt();
		for (int i = 0; i < b.length; i++)
			b[i] = sc.nextInt();
		Arrays.sort(a);
		Arrays.sort(b);
		int count = 0;
		int indexa = 0;
		int indexb = 0;
		while ((indexa != a.length && indexb != b.length)) {
			if ((double) b[indexb] / (double) a[indexa] < 2)
				indexb++;
			else if ((double) b[indexb] / (double) a[indexa] > 3)
				indexa++;
			else {
				count++;
				indexa++;
				indexb++;
			}
		}
		System.out.println(count);
	}

}
