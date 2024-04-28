import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SortNumbers {

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = sc.nextInt();
		List<Number> numbers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			Number num1 = new Number(num, i);
			numbers.add(num1);
		}
		numbers.sort((s1, s2) -> {
			int compare = Integer.compare(s1.num, s2.num);
			return compare;
		});
		for (Number num : numbers) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);

	}

	static class Number {
		public int num;
		public int index;

		Number(int num, int index) {
			this.num = num;
			this.index = index;
		}

		@Override
		public String toString() {
			return num + " " + index;
		}
	}
}
