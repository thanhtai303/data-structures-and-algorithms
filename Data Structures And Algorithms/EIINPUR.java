import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIINPUR {
	static InputReader sc = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		double originalDebt = sc.nextDouble();
		double payPerMonth = sc.nextDouble();
		int month = sc.nextInt();
		int k = sc.nextInt();
		double highInterest = 1;
		double lowInterest = 0;
		double midInterest = 0;
		while (highInterest - lowInterest > 0.000000001) {
			midInterest = (highInterest + lowInterest) / 2;
			double debt = getDebt(originalDebt, payPerMonth, month, midInterest, k);
			if (debt < 0) {
				highInterest = midInterest;

			} else
				lowInterest = midInterest;
		}

		System.out.println(sb);
	}

	public static double getDebt(double originalDebt, double payPerMonth, int month, double interestRate, int k) {
		double totalPayment = 0;
		for (int i = 1; i <= month; i++) {
			originalDebt += originalDebt * (interestRate/100);
			originalDebt -= payPerMonth;
			totalPayment += payPerMonth;
			if (i == k)
				break;
		}
		sb.append(totalPayment).append( " ");
		return originalDebt;
	}

	static class InputReader {

		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
