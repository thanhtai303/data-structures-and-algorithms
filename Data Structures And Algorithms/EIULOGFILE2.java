import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIULOGFILE2 {
	static InputReader sc = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int numberOfLogfiles = sc.nextInt();
		int numberOfEvent = sc.nextInt();
		long[] listOfLogFiles = new long[numberOfLogfiles];
		for (int i = 0; i < numberOfLogfiles; i++)
			listOfLogFiles[i] = sc.nextLong();
		Arrays.sort(listOfLogFiles);
		LogFile logFile = new LogFile(numberOfLogfiles, numberOfEvent);
		logFile.findEvents(listOfLogFiles);
	}

	public static class LogFile {
		public static int numberOfLogfiles;
		public static int numberOfEvents;

		public LogFile(int numberOfLogfiles, int numberOfEvents) {
			this.numberOfLogfiles = numberOfLogfiles;
			this.numberOfEvents = numberOfEvents;
		}

		public static void findEvents(long[] listOfLogFiles) {
			for (int i = 0; i < numberOfEvents; i++) {
				int event = Arrays.binarySearch(listOfLogFiles, sc.nextLong());
				if (event < 0)
					event = ~event;
				if (event < numberOfLogfiles)
					sb.append(listOfLogFiles[event]).append(" ");
				else
					sb.append(-1).append(" ");
			}
			System.out.println(sb);
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