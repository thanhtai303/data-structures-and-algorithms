import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EI2121Q1M1 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfStaffs = reader.nextInt();
		List<Staff> staffList = new ArrayList<>();
		for (int i = 0; i < numberOfStaffs; i++) {
			String ID = reader.next();
			String name = reader.next();
			long startYear = reader.nextLong();
			Staff staff = new Staff(ID, name, startYear);
			staff.getWorkingYear();
			staffList.add(staff);
		}
		staffList.sort((s1, s2) -> {
			int compare =Long.compare(s2.workingYear, s1.workingYear);
			if (compare == 0) {
				compare = s1.name.compareTo(s2.name);
			}
			if (compare == 0) {
				compare = s1.ID.compareTo(s2.ID);
			}
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		for (Staff i : staffList) {
			sb.append(i);
		}
		System.out.print(sb);
	}

	static class Staff {
		public String ID;
		public String name;
		public long startYear;
		public long workingYear;

		public Staff(String iD, String name, long startYear) {
			this.ID = iD;
			this.name = name;
			this.startYear = startYear;
		}

		public void getWorkingYear() {
			this.workingYear =(long) 2021 - startYear;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.ID).append(" ").append(this.name).append(" ").append(this.workingYear).append("\n");
			return sb.toString();

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
