import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;

public class EIGRADU {

	static InputReader sc = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int numStu = sc.nextInt();
		int minCredits=sc.nextInt();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < numStu; i++) {
			String ID = sc.next();
			String name = sc.next();
			int numOfSubject = sc.nextInt();
			Student student = new Student(ID, name, numOfSubject);
			student.getAverage();
			students.add(student);
		}
		students.sort((s1, s2) -> {
			int compare = Integer.compare(s2.average, s1.average);
			if(compare==0) {
				compare=(s1.ID.compareTo(s2.ID));
			}
			return compare;
		});
		for (Student stu : students) {
			if (stu.credits>=minCredits) {
				sb.append(stu).append("\n");
			}
		}
		System.out.print(sb);
	}

	static class Student {
		public String ID;
		public String name;
		public int numberOfSubjects;
		public int numberOfPassSubject;
		public int totalGrades = 0;
		public int average;
		public int credits;

		public Student(String ID, String name, int numberOfSubject) {
			this.ID = ID;
			this.name = name;
			this.numberOfSubjects = numberOfSubject;
		}

		public int getAverage() {
			for (int i = 1; i <= numberOfSubjects; i++) {
				int score = sc.nextInt();
				if (score >= 50) {
					credits += 4;
					totalGrades += score;
					numberOfPassSubject++;
					average = totalGrades / numberOfPassSubject;
				}
			}
			return average;
		}

		@Override
		public String toString() {
			return ID+" "+name + " " + Math.round(average);
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
