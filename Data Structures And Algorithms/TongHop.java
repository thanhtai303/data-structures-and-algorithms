import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TongHop {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int money=sc.nextInt();
		int month=sc.nextInt();
		Account acc=new Account(month, money);
		acc.countInterest();
		System.out.println(acc);
	}

	static class Account {
		public double month;
		public double money;
		public double originalMoney;
		public double interest;

		public Account(int month, int money) {
			this.month = month;
			this.money = money;
		}

		public void countInterest() {
			this.originalMoney=this.money/this.month;
			if (this.month == 1) {
				 this.interest = (originalMoney * 0.039);
			} else if (this.month == 2) {
				 this.interest = (originalMoney * 0.039) + (originalMoney * 0.0392);
			} else if (this.month == 3) {
				 this.interest = (originalMoney * 0.039) + (originalMoney * 0.0392) + (originalMoney * 0.0395);
			} else {
				 this.interest = (originalMoney * 0.039) + (originalMoney * 0.0392) + (originalMoney * 0.0395)
						+ (originalMoney * 0.0399);

			}
		}

		@Override
		public String toString() {
			StringBuilder sb=new StringBuilder();
			return sb.append(Math.round (this.money+this.interest)).toString();
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
