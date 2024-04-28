import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MissionImpossible {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		List<Name> nameList = new ArrayList<>();
		int numberOfName = sc.nextInt();
		for (int i = 0; i < numberOfName; i++) {
			String name = sc.nextLine();
			String[] nameString = name.split(" ");
			String firstName = " ";
			String middleName = " ";
			String lastName = nameString[0];
			if (nameString.length == 2) {
				firstName = nameString[1];
			} else if (nameString.length > 2) {
				firstName = nameString[nameString.length - 1];
				for (int j=1;j<nameString.length-1;j++)
				middleName+=nameString[j]+" ";
			}
			Name name1 = new Name(lastName, firstName, middleName);
			name1.fullName = name;
			nameList.add(name1);
		}
		nameList.sort((s1, s2) -> {
			int compare = (s1.firstName.compareTo(s2.firstName));
			if (compare == 0)
				compare = (s1.lastName.compareTo(s2.lastName));
			if (compare == 0)
				compare = (s1.middleName.compareTo(s2.middleName));
			return compare;
		});
		for (Name n : nameList) {
			sb.append(n);
		}
		System.out.println(sb);

	}

	static class Name {
		public String fullName;
		public String lastName;
		public String firstName;
		public String middleName;

		Name(String lastName, String firstName, String middleName) {
			this.lastName = lastName;
			this.firstName = firstName;
			this.middleName = middleName;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(fullName).append("\n");
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
