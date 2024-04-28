import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class LessonAttendance {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		long numberAttendance = sc.nextLong();
		HashMap<String, Lesson> lessonMap = new HashMap<>();
		HashMap<String, Student> studentMap = new HashMap<>();
		int numberOfStudent = 0;
		for (int i = 0; i < numberAttendance; i++) {
			String startTime = sc.next();
			String studentID = sc.next();
			String classID = sc.next();
			int checkin = sc.nextInt();
			Student student =new Student(studentID);
			if(!studentMap.containsKey(studentID)) {
				studentMap.put(studentID, student);
				numberOfStudent++;
			}
			if (lessonMap.containsKey(startTime) && checkin == 1) {
				lessonMap.get(startTime).numberOfstudent++;
			} else {
				if (checkin == 1) {
					Lesson lesson = new Lesson(startTime, classID);
					lesson.numberOfstudent++;
					lessonMap.put(startTime, lesson);
				}
			}

		}
		List<Lesson> lessonList = new ArrayList<>(lessonMap.values());
		for (Lesson i : lessonList) {
			i.studentRate = i.numberOfstudent /(double) numberOfStudent;
		}
		lessonList.sort((s1, s2) -> {
			int compare = Double.compare(s2.studentRate, s1.studentRate);
			if (compare == 0)
				compare = s1.startTime.compareTo(s2.startTime);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		for (Lesson i : lessonList) {
			sb.append(i);
		}
		System.out.println(sb);
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
		public double numberOfstudent;
		public double studentRate;

		public Lesson(String startTime, String classID) {
			this.startTime = startTime;
			this.classID = classID;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(startTime).append(" ").append(String.format("%.2f", studentRate)).append("\n");
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
