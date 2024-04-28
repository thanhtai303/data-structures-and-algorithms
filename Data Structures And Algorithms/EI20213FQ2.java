import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EI20213FQ2 {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfTransaction = sc.nextInt();
		int numberOfHighestProduct = sc.nextInt();
		HashMap<String, Product> productMap = new HashMap<>();
		for (int i = 0; i < numberOfTransaction; i++) {
			String transactionCode = sc.next();
			String productCode = sc.next();
			double sellingPrice = sc.nextDouble();
			double quantity = sc.nextDouble();
			double costPerUnit = sc.nextDouble();
			Product product = new Product(productCode);
			if (!productMap.containsKey(productCode)) {
				productMap.put(productCode, product);
				productMap.get(productCode).sellingPriceList.add((sellingPrice - costPerUnit) * quantity);
			} else
				productMap.get(productCode).sellingPriceList.add((sellingPrice - costPerUnit) * quantity);
		}
		List<Product> productList = new ArrayList<>(productMap.values());
		for (Product product : productList) {
			product.getTotalSellingPrice();
		}
		productList.sort((s1, s2) -> {
			int compare = Double.compare(s2.totalSellingPrice, s1.totalSellingPrice);
			if (compare == 0) {
				compare = s1.productCode.compareTo(s2.productCode);
			}
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		if (productList.size() > numberOfHighestProduct) {
			double temp = productList.get(numberOfHighestProduct-1).totalSellingPrice;
			for (Product product : productList) {
				if (temp > product.totalSellingPrice) {
					break;
				}
				sb.append(product);
			}
		} else
			for (int i = 0; i < productList.size(); i++) {
				sb.append(productList.get(i));
				if(i==numberOfHighestProduct-1)
					break;
			}
		System.out.println(sb);
	}

	static class Product {
		public List<Double> sellingPriceList = new ArrayList<>();
		public String productCode;
		public double totalSellingPrice;

		public Product(String productCode) {
			this.productCode = productCode;
		}

		public void getTotalSellingPrice() {
			for (Double i : sellingPriceList)
				totalSellingPrice += i;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(productCode).append(" ").append(Math.round(totalSellingPrice)).append("\n");
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
