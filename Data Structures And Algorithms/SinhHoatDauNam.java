import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class SinhHoatDauNam {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		long students = sc.nextLong();
		HashMap<Integer, Integer> groups = new HashMap<>();
		for (int j = 0; j < students; j++) {
			int group = sc.nextInt();
			if (groups.containsKey(group))
				groups.put(group, groups.get(group) + 1);
			else
				groups.put(group, 1);
		}
		List<Integer> studentsList = new ArrayList<>(groups.keySet());
		studentsList.sort((s1, s2) -> s2 - s1);
		for (int student:studentsList) {
			sb.append(student).append("\t").append(groups.get(student)).append("\n");
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
