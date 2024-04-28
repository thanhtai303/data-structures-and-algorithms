import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EISEAW {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfEmployees = reader.nextInt();
		List<Employee> employeesList = new ArrayList<>();
		for (int i = 0; i < numberOfEmployees; i++) {
			String name = reader.next();
			long wagePerHour = reader.nextLong();
			long workingDays = reader.nextLong();
			Employee employee = new Employee(name, wagePerHour, workingDays);
			employee.getTotalWorkingHours();
			employeesList.add(employee);
		}
		employeesList.sort((s1, s2) -> {
			int compare = Long.compare(s1.income, s2.income);
			if (compare == 0)
				compare = s1.name.compareTo(s2.name);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		for (Employee emp : employeesList) {
			sb.append(emp);
		}
		System.out.print(sb);

	}

	static class Employee {
		public String name;
		public long wagePerHour;
		public long workingDays;
		public long totalWorkingHours;
		public long income;

		public Employee(String name, long wagePerHour, long workingDays) {
			this.name = name;
			this.wagePerHour = wagePerHour;
			this.workingDays = workingDays;
		}

		public void getTotalWorkingHours() {
			for (int i = 0; i < workingDays; i++)
				this.totalWorkingHours += reader.nextLong();
			this.income = totalWorkingHours * this.wagePerHour;
			if (this.income >= 2000000) {
				this.income -= this.income * 0.1;
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.name).append(" ").append(this.totalWorkingHours).append(" ").append(income).append("\n");
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
