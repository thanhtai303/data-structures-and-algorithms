import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIHPROFIT {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {

		int numberOfProducts = sc.nextInt();
		int numberOfTopProducts = sc.nextInt();
		List<Product> productList = new ArrayList<>();
		for (int i = 0; i < numberOfProducts; i++) {
			long ID = sc.nextLong();
			String name = sc.next();
			double cost = sc.nextDouble();
			double price = sc.nextDouble();
			double quatity = sc.nextDouble();
			double profit = (cost - price) * quatity;
			Product product = new Product(ID, name, cost, price, quatity, profit);
			productList.add(product);
		}
		productList.sort((s1, s2) -> {
			int compare = Double.compare(s2.profit, s1.profit);
			if (compare == 0)
				compare = Long.compare(s1.ID, s2.ID);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		if (productList.size() > numberOfTopProducts) {
			double temp = productList.get(numberOfTopProducts - 1).profit;
			for (Product product : productList) {
				if (temp > product.profit) {
					break;
				}
				sb.append(product);
			}
		} else
			for (int i = 0; i < productList.size(); i++) {
				sb.append(productList.get(i));
				if (i == numberOfTopProducts - 1)
					break;
			}
		System.out.println(sb);
	}

	static class Product {
		public long ID;
		public String name;
		public double cost;
		public double price;
		public double quantity;
		public double profit;

		public Product(long ID, String name, double cost, double price, double quantity, double profit) {
			this.ID = ID;
			this.name = name;
			this.cost = cost;
			this.price = price;
			this.quantity = quantity;
			this.profit = profit;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.ID).append(" ").append(this.name).append(" ").append(Math.round(this.profit)).append("\n");
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
