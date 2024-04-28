import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

 public class EIGPA3 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int numberOfCholarships = reader.nextInt();
		HashMap<Long, Student> studentsMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			long ID = reader.nextLong();
			String courseCode = reader.next();
			double overall = reader.nextDouble();
			Student student = studentsMap.get(ID);
			if (student == null) {
				student = new Student(ID);
				if (overall >= 50) {
					student.courses.put(courseCode, overall);
				}
				studentsMap.put(ID, student);
			} else {
				if (student.courses.containsKey(courseCode) && overall >= 50) {
					student.courses.replace(courseCode, overall);
				} else {
					if (overall >= 50) {
						student.courses.put(courseCode, overall);
					}
				}
			}
			student.getAverage();
		}
		List<Student> studentList = new ArrayList<>(studentsMap.values());
		for (Student student : studentList) {
			student.getAverage();
		}
		studentList.sort((s1, s2) -> {
			int compare = Double.compare(s2.average, s1.average);
			if (compare == 0)
				compare = Long.compare(s1.ID, s2.ID);
			return compare;
		});
		if (studentList.size() > numberOfCholarships) {
			double temp = studentList.get(numberOfCholarships).average;
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).average > temp)
					sb.append(studentList.get(i));
			}
		} else
			for (int i = 0; i < numberOfCholarships; i++) {
				sb.append(studentList.get(i));
			}

		System.out.println(sb);
	}

	static class Student {
		public long ID;
		public HashMap<String, Double> courses = new HashMap<>();
		public double average;

		public Student(long ID) {
			this.ID = ID;
		}

		public double getAverage() {
			List<Double> gradesList = new ArrayList<>(courses.values());
			double totalGrade = 0;
			for (Double i : gradesList) {
				totalGrade += i;
			}
			average = totalGrade / (double) courses.size();
			return average;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(ID).append(" ").append(Math.round(average)).append("\n");
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
