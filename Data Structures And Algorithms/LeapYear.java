import java.util.*;

public class LeapYear {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++)
			a[i] = sc.nextInt();
		for (int j = 0; j < a.length; j++) {
			if (LeapYears(a[j]))
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

	public static boolean LeapYears(int a) {
		if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0))
			return true;
		return false;

	}
}
