import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EI20213FQ3 {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfTransaction = sc.nextInt();
		HashMap<String, Product> productMap = new HashMap<>();
		for (int i = 0; i < numberOfTransaction; i++) {
			String transactionCode = sc.next();
			String productCode = sc.next();
			double sellingPrice = sc.nextDouble();
			double quantity = sc.nextDouble();
			Product product = new Product(productCode);
			if (!productMap.containsKey(productCode)) {
				productMap.put(productCode, product);
				productMap.get(productCode).revenue.put(sellingPrice, quantity);
			} else {
				if (productMap.get(productCode).revenue.containsKey(sellingPrice)) {
					productMap.get(productCode).revenue.replace(sellingPrice,
							(productMap.get(productCode).revenue.get(sellingPrice) + quantity));
				} else
					productMap.get(productCode).revenue.put(sellingPrice, quantity);
			}
		}
		List<Product> productList = new ArrayList<>(productMap.values());
		productList.sort((s1, s2) -> {
			int compare = s1.productCode.compareTo(s2.productCode);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		for (Product i : productList) {
			i.getRevenue();
			sb.append(i);
		}
		System.out.println(sb);
	}

	static class Product {
		public HashMap<Double, Double> revenue = new HashMap<>();
		public String productCode;
		public double highestRevenue;
		public double quantity;
		public double sellingPrice;

		public Product(String productCode) {
			this.productCode = productCode;
		}

		public void getRevenue() {
			List<Double> sellingPriceList = new ArrayList<>(revenue.keySet());
			for (Double i : sellingPriceList) {
				if (this.revenue.get(i) * i > this.highestRevenue) {
					this.highestRevenue = this.revenue.get(i) * i;
					this.sellingPrice = i;
				}
				if (revenue.get(i) * i == this.highestRevenue && i < sellingPrice) {
					this.sellingPrice = i;
				}
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(productCode).append(" ").append(Math.round(sellingPrice)).append(" ")
					.append(Math.round(highestRevenue)).append("\n");
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
