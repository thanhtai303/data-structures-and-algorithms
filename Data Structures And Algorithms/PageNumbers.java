import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class PageNumbers {
	static InputReader sc = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = sc.nextInt();
		long[] pages = new long[n];
		for (int i = 0; i < n; i++) {
			pages[i] = sc.nextInt();
		}

		Arrays.sort(pages);
		for (int i = 0; i < n ; i++) {
			if (i<n-1 && pages[i] - pages[i + 1] == -1) {
				int j = i;
				while (pages[j] - pages[j + 1] == -1) {
					j++;
				}
				if (j - i >= 2 && j<n) {
					sb.append(pages[i]).append("-").append(pages[j]).append(" ");
					i = j;
				} else
					sb.append(pages[i]).append(" ");

			} else
				sb.append(pages[i]).append(" ");
		}
		System.out.print(sb);

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
