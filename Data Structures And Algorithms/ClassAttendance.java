import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ClassAttendance {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		long numberAttendance = sc.nextLong();
		HashMap<String, Student> studentMap = new HashMap<>();
		for (int i = 0; i < numberAttendance; i++) {
			String startTime = sc.next();
			String studentID = sc.next();
			String classID = sc.next();
			int checkin = sc.nextInt();
			if (studentMap.containsKey(studentID)) {
				if (checkin == 0) {
					studentMap.get(studentID).absent++;
				} else
					studentMap.get(studentID).attendance++;
			} else {
				if (checkin == 1) {
					Student student = new Student(studentID);
					student.attendance++;
					studentMap.put(studentID, student);
				} else {
					if (checkin == 0) {
						Student student = new Student(studentID);
						student.absent++;
						studentMap.put(studentID, student);
					}
				}

			}

		}
		List<Student> studentList = new ArrayList<>(studentMap.values());
		studentList.sort((s1, s2) -> {
			int compare = s1.studentID.compareTo(s2.studentID);
			return compare;
		});
		StringBuilder output = new StringBuilder();
		long temp = 0;
		for (Student i : studentList) {
			if (i.absent == 0) {
				temp = i.attendance;
			}
		}
		for (Student i:studentList) {
			i.absent=temp-i.attendance;
			output.append(i);
		}
		System.out.println(output);
	}

	static class Student {
		public String studentID;
		public long absent;
		public long attendance;

		public Student(String studentID) {
			this.studentID = studentID;
		}

		@Override
		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(this.studentID).append(" ").append(absent).append(" ").append(attendance).append("\n");
			return output.toString();
		}
	}

	static class Lesson {
		public String startTime;
		public String classID;
		public HashMap<String, Student> lessonMap = new HashMap<>();

		public Lesson(String startTime, String classID) {
			this.startTime = startTime;
			this.classID = classID;
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
