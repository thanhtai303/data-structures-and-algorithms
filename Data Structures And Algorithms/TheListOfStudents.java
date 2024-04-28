import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TheListOfStudents {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		List<Student> studentsList = new ArrayList<>();
		int numberOfStudents = sc.nextInt();
		for (int i = 0; i < numberOfStudents; i++) {
			long studentID = sc.nextLong();
			String name = sc.next();
			int age = sc.nextInt();
			int majorCode = sc.nextInt();

			Student student = new Student(name, age, majorCode, studentID);
			studentsList.add(student);
		}
		studentsList.sort((s1, s2) -> {
			long compare = Long.compare(s1.studentID, s2.studentID);
			return (int) compare;
		});

		for (Student student : studentsList) {
			sb.append(student);
		}
		System.out.print(sb);
	}

	static class Student {
		public String name;
		public int age;
		public int majorCode;
		public long studentID;

		Student(String name, int age, int majorCode, long studentID) {
			this.name = name;
			this.age = age;
			this.majorCode = majorCode;
			this.studentID = studentID;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(studentID).append(" ").append(name).append(" ").append(age).append(" ").append(majorCode)
					.append("\n");
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
