import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class BuyGifts {
	static InputReader sc = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			long n = sc.nextLong();
			HashMap<Long, Long> gifts = new HashMap<>();
			for (int j = 0; j < n; j++) {
				long price = sc.nextLong();
				if (gifts.containsKey(price))
					gifts.put(price, gifts.get(price) + 1);
				else
					gifts.put(price, (long) 1);
			}
			long way = 0;
			List<Long> key = new ArrayList<>(gifts.keySet());
			for (Long a : key)
				way += (gifts.get(a) * (gifts.get(a) - 1)) / 2;
			sb.append(way + " ");
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
