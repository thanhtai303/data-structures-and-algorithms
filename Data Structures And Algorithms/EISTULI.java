import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EISTULI {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		long numberOfStudents = sc.nextLong();
		int highestGPANumber = sc.nextInt();
		List<Student> studentsList = new ArrayList<>();
		for (int i = 0; i < numberOfStudents; i++) {
			String ID = sc.next();
			String name = sc.next();
			long numberOfCourses = sc.nextLong();
			Student student = new Student(ID, name, numberOfCourses);
			student.getGrades();
			student.getCredits();
			studentsList.add(student);

		}
		studentsList.sort((s1, s2) -> {
			int compare = Double.compare(s2.average, s1.average);
			return compare;
		});
		if (studentsList.size() > highestGPANumber) {
			double temp = studentsList.get(highestGPANumber).average;
			for (int i = 0; i < highestGPANumber; i++) {
				if (studentsList.get(i).average <= temp)
					break;
				else
					sb.append(studentsList.get(i));
			}
		} else {
			for (int i = 0; i < highestGPANumber; i++) {
				sb.append(studentsList.get(i));
			}
		}
		System.out.print(sb);

	}

	static class Student {
		public String ID;
		public String name;
		public long numberOfCourses;
		public List<Double> passGradesList = new ArrayList<>();
		public Double average;
		public long credits;

		public Student(String ID, String name, long numberOfCourses) {
			this.ID = ID;
			this.name = name;
			this.numberOfCourses = numberOfCourses;
		}

		public void getGrades() {
			double totalGrades = 0;
			for (int i = 0; i < numberOfCourses; i++) {
				double grade = sc.nextDouble();
				if (grade >= 50) {
					passGradesList.add(grade);
					totalGrades += grade;
				}
			}
			this.average = totalGrades / passGradesList.size();
		}

		public void getCredits() {
			this.credits = passGradesList.size() * 4;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(this.ID).append(" ").append(this.name).append(" ").append(Math.round(this.average)).append(" ")
					.append(this.credits).append("\n");
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
