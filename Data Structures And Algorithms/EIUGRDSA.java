import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIUGRDSA {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		int numberOfStudent = sc.nextInt();
		int numberOfProblem = sc.nextInt();
		int numberOfSubmission = sc.nextInt();
		HashMap<Integer, Student> studentMap = new HashMap<>();

		for (int i = 0; i < numberOfStudent; i++) {
			int studentID = sc.nextInt();
			Student student = new Student(studentID, numberOfProblem);
			studentMap.put(studentID, student);
		}
		String problemCodeTXT = sc.nextLine();

		for (int i = 0; i < numberOfSubmission; i++) {
			int studentID = sc.nextInt();
			int problemCode = sc.nextInt();
			double score = sc.nextDouble();
			Student student=studentMap.get(studentID);
			if (student.scoresMap.containsKey(problemCode)) {
				if (student.scoresMap.get(problemCode) < score
						|| student.scoresMap.get(problemCode) == null) {
					student.scoresMap.replace(problemCode, score);
				}
			} else {
				student.scoresMap.put(problemCode, score);
			}
			student.getAverage();
			studentMap.put(studentID, student);
		}
		List<Student> studentList = new ArrayList<>(studentMap.values());
		studentList.sort((s1, s2) -> {
			int compare = Integer.compare(s1.studentID, s2.studentID);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		for (Student i : studentList) {
			sb.append(i);
		}
		System.out.println(sb);

	}

	static class Student {
		public int studentID;
		public double numberOfProblem;
		public HashMap<Integer, Double> scoresMap = new HashMap<>();
		public double average;

		public Student(int studentID, double numberOfProblem) {
			this.studentID = studentID;
			this.numberOfProblem = numberOfProblem;
		}

		public void getAverage() {
			List<Double> scoreList = new ArrayList<>(scoresMap.values());
			double totalScore = 0;
			for (Double i : scoreList) {
				totalScore += i;
			}
			average = totalScore / numberOfProblem;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(studentID).append(" ").append((int)(average)).append("\n");
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
