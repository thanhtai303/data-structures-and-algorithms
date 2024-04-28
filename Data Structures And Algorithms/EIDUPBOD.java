import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIDUPBOD {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfStudent = sc.nextInt();
		HashMap<String, Integer> dateOfBirthMap = new HashMap<>();
		List<DOB> dateOfBirthList = new ArrayList<>();
		for (int i = 0; i < numberOfStudent; i++) {
			int day = sc.nextInt();
			int month = sc.nextInt();
			int year = sc.nextInt();
			String dateOfBirth="";
			if (day / 10 < 1) {
				dateOfBirth += "0" + (day) + "/";
			} else
				dateOfBirth += (day) + "/";
			if (month / 10 < 1) {
				dateOfBirth += "0" + month + "/";
			} else
				dateOfBirth += (month) + "/";
			dateOfBirth += year;

			if (dateOfBirthMap.containsKey(dateOfBirth)) {
				dateOfBirthMap.replace(dateOfBirth, dateOfBirthMap.get(dateOfBirth) + 1);
			} else {
				dateOfBirthMap.put(dateOfBirth, 1);
				DOB dob = new DOB(day, month, year, dateOfBirth);
				dateOfBirthList.add(dob);
			}
		}
		dateOfBirthList.sort((s1, s2) -> {
			int compare = Integer.compare(s1.year, s2.year);
			if (compare == 0)
				compare = Integer.compare(s1.month, s2.month);
			if (compare == 0)
				compare = Integer.compare(s1.day, s2.day);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		for (DOB i : dateOfBirthList) {
			sb.append(i).append(" ").append(dateOfBirthMap.get(i.dateOfBirth)).append("\n");
		}
		System.out.println(sb);
	}

	static class DOB {
		public int day;
		public int month;
		public int year;
		public String dateOfBirth;

		public DOB(int day, int month, int year, String dateOfBirth) {
			this.day = day;
			this.month = month;
			this.year = year;
			this.dateOfBirth = dateOfBirth;
		}

		@Override
		public String toString() {
			return dateOfBirth;
		}
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
