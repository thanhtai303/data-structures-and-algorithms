import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EILAPTOP2 {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfLaptops = sc.nextInt();
		List<Laptop> laptopList = new ArrayList<>();
		for (int i = 0; i < numberOfLaptops; i++) {
			long price = sc.nextLong();
			long speed = sc.nextLong();
			Laptop laptop = new Laptop(price, speed);
			laptopList.add(laptop);
		}
		laptopList.sort((s1, s2) -> {
			int compare = Long.compare(s2.price, s1.price);
			return compare;
		});
		if (checkLaptop(laptopList)) {
			System.out.print("Happy Beo");
		} else
			System.out.print("Poor Beo");

	}

	public static boolean checkLaptop(List<Laptop> laptopList) {
		long count = 0;
		for (int i = 0; i < laptopList.size(); i++) {
			for (int j = i + 1; j < laptopList.size(); j++) {
				if (laptopList.get(i).speed <= laptopList.get(j).speed) {
					count++;
				} else
					break;
				if (count >= laptopList.size() / 10)
					return true;

			}

		}
		return false;
	}

	public static class Laptop {
		public long price;
		public long speed;

		public Laptop(long price, long speed) {
			this.price = price;
			this.speed = speed;
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
