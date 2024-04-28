
import java.util.*;
import java.io.*;

public class Polinomial {
	static StringBuilder sb = new StringBuilder();
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			double x = sc.nextDouble();
			sb.append(PolinomialX(n, x) + "\n");
		}
		System.out.print(sb);
	}

	public static double PolinomialX(int n, double x) {
		double result = 0;
		for (int k = 0; k <= n; k++) {
			result += (sc.nextDouble() * Math.pow(x, n - k));
		}

		return result;
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
