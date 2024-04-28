import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIBEST {
	static InputReader sc = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int numStu = sc.nextInt();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < numStu; i++) {
			String name = sc.next();
			double numOfSubject = sc.nextInt();
			Student student = new Student(name, numOfSubject);
			student.getAverage();
			students.add(student);
		}
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.average, s1.average);
			return compare;
		});
		double temp = students.get(0).average;
		for (Student stu : students) {
			if (stu.average == temp) {
				sb.append(stu).append("\n");
			}
		}
		System.out.print(sb);
	}

	static class Student {
		public String name;
		public double numberOfSubjects;
		public double numberOfPassSubject;
		public double totalGrades = 0;
		public double average;

		public Student(String name, double numberOfSubject) {
			this.name = name;
			this.numberOfSubjects = numberOfSubject;
		}

		public double getAverage() {
			for (int i = 1; i <= numberOfSubjects; i++) {
				int score = sc.nextInt();
				if (score >= 50) {
					totalGrades += score;
					numberOfPassSubject++;
					average = totalGrades / numberOfPassSubject;
				}
			}
			return average;
		}

		@Override
		public String toString() {
			return name + " " + Math.round(average);
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
