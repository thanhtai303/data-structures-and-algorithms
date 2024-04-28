import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EISCH4 {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {

		int numberOfStudent = sc.nextInt();
		int numberOfScholarship = sc.nextInt();
		double minimumCredit = sc.nextInt();
		double requiredGPA = sc.nextDouble();
		List<Student> studentList = new ArrayList<>();

		for (int i = 0; i < numberOfStudent; i++) {
			String name = sc.next();
			int numberOfCourses = sc.nextInt();
			Student student = new Student(name);
			for (int j = 0; j < numberOfCourses; j++) {
				double score = sc.nextDouble();
				student.getTotalScore(score);
			}
			student.getAverage();
			studentList.add(student);
		}
		studentList.sort((s1, s2) -> {
			int compare = Double.compare(s2.average, s1.average);
			if (compare == 0)
				compare = s1.name.compareTo(s2.name);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		List<Student> studentPassList = new ArrayList<>();
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).average >= requiredGPA && studentList.get(i).totalCredit >= minimumCredit) {
				studentPassList.add(studentList.get(i));
			}
		}
		if (studentPassList.size() > numberOfScholarship) {
			double temp = studentPassList.get(numberOfScholarship).average;
			for (int i = 0; i < studentPassList.size(); i++) {
				if (studentPassList.get(i).average > temp) {
					sb.append(studentPassList.get(i));
				} else
					break;
			}
		} else
			for (int i = 0; i < studentPassList.size(); i++) {
				if (numberOfScholarship == 0) {
					break;
				}
				sb.append(studentPassList.get(i));
				numberOfScholarship--;
			}
		System.out.println(sb);
	}

	static class Student {
		public String name;
		public double totalCredit;
		public double average;
		public double totalScore = 0;
		public double numberPassScore = 0;

		public Student(String name) {
			this.name = name;
		}

		public void getTotalScore(double score) {
			if (score >= 50) {
				this.totalScore += score;
				this.numberPassScore++;
			}
		}

		public void getAverage() {
			if (numberPassScore == 0) {
				totalCredit = 0;
				average = 0;
				return;
			}
			this.average = totalScore / numberPassScore;
			this.totalCredit = 4 * numberPassScore;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.name).append(" ").append(average).append("\n");
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
