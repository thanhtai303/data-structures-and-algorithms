import java.util.*;

public class KGreatesNumbers {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {

		int n = sc.nextInt();
		int m = sc.nextInt();
		long[] a = new long[n];

		for (int i = 0; i < a.length; i++)
			a[i] = sc.nextLong();

		Arrays.sort(a);

		int b = a.length - 1;
		for (int i = 0; i < m; i++) {
			sb.append(a[b]+" ");
			b--;
		}
		System.out.println(sb);

	}
}
