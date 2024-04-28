	import java.io.BufferedReader;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.*;
	
	public class Letter {
		static InputReader sc = new InputReader(System.in);
	
		public static void main(String[] args) {
			String a = sc.next();
			String b = sc.next();
			String c = letter(a, b);
			System.out.println(c.length());
	
		}
	
		public static String letter(String a, String b) {
			int i = 0;
			int j = 0;
			while (i < a.length()) {
				if (a.charAt(i) == b.charAt(j) && i < a.length() - 1)
					while (i < a.length()) {
						if (a.charAt(i) == b.charAt(j)) {
							i++;
							++j;
						}
						else
							break;
					} else if (j==0 && a.charAt(a.length() - 1) == b.charAt(0))
						return a + b.substring(1);
				else
					i++;
			}
	
			return a + b.substring(j);
		}
	
		public static String removeChartAtPosition(String s, int pos) {
			return s.substring(0, pos) + s.substring(pos + 1);
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
