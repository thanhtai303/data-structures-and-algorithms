import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EITOPK {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfStudents = sc.nextInt();
		int numberOfHighestGPAStudents = sc.nextInt();
		List<Student> studentList = new ArrayList<>();
		for (int i = 0; i < numberOfStudents; i++) {
			String name = sc.next();
			int numberOfSubjects = sc.nextInt();
			Student student = new Student(name);
			for (int j = 0; j < numberOfSubjects; j++) {
				double grade = sc.nextDouble();
				if (grade >= 50)
					student.passGrade.add(grade);
			}
			student.getResult();
			studentList.add(student);
		}
		studentList.sort((s1, s2) -> {
			int compare = Double.compare(s2.average, s1.average);
			if (compare == 0)
				compare = Double.compare(s2.totalCredit, s1.totalCredit);
			if (compare == 0)
				compare = s1.name.compareTo(s2.name);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		if (studentList.size() > numberOfHighestGPAStudents) {
			double temp = studentList.get(numberOfHighestGPAStudents).average;
			for (int i=0;i<studentList.size();i++) {
				if (temp < studentList.get(i).average) {
					sb.append(studentList.get(i));
				}if(i==numberOfHighestGPAStudents-1)
					break;
				
			}
		} else
			for (int i = 0; i < studentList.size(); i++) {
				sb.append(studentList.get(i));
				if (i == numberOfHighestGPAStudents )
					break;

			}
		System.out.println(sb);
	}

	static class Student {
		public String name;
		public List<Double> passGrade = new ArrayList<>();
		public double totalCredit;
		public double average;

		public Student(String name) {
			this.name = name;
		}

		public void getResult() {
			double totalGrade = 0;
			for (Double i : passGrade) {
				totalGrade += i;
			}
			this.average = totalGrade / this.passGrade.size();
			this.totalCredit = this.passGrade.size() * 4;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(name).append(" ").append(Math.round(average)).append(" ").append(Math.round(totalCredit))
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
