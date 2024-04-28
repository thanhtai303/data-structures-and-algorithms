import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class GPA {
	public static void main(String[] args) {
		InputReader sc = new InputReader(System.in);
		StringBuilder outPut = new StringBuilder();
		List<Student> studentsList = new ArrayList<>();
		int numberOfStudents = sc.nextInt();
		for (int i = 0; i < numberOfStudents; i++) {
			String name = sc.next();
			int numberOfSubjects = sc.nextInt();
			Student student = new Student(name);
			for (int j = 0; j < numberOfSubjects; j++) {
				int score = sc.nextInt();
				student.passSubjectsList(score);

			}
			studentsList.add(student);

		}
		for (Student student : studentsList)
			outPut.append(student);

		System.out.print(outPut);

	}

	static class Student {
		public String name;
		public int averageScore;
		public int totalPassSubjectsScores;
		public List<Integer> passScores = new ArrayList<>();

		Student(String name) {
			this.name = name;
		}

		public void passSubjectsList(int score) {
			if (score >= 50) {
				passScores.add(score);
				totalPassSubjectsScores += score;
				averageScore = totalPassSubjectsScores / passScores.size();
			}

		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(name).append(" ");
			for (int i : passScores) {
				sb.append(i).append(" ");
			}
			sb.append(averageScore).append("\n");
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
