import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class EI20213FQ1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		long numberOfTransactions = reader.nextLong();
		HashMap<String, Product> map = new HashMap<>();
		for (int i = 0; i < numberOfTransactions; i++) {
			String transactionCode = reader.next();
			String productCode = reader.next();
			double sellingPrice = reader.nextDouble();
			double quantity = reader.nextDouble();
			Product product = map.get(productCode);
			if (product == null) {
				product = new Product(productCode);
				product.totalQuantity = quantity;
				product.totalSellingPrice = sellingPrice * quantity;
				map.put(productCode, product);
			} else {
				product.totalQuantity += quantity;
				product.totalSellingPrice += sellingPrice * quantity;
			}
		}
		List<Product> productList = new ArrayList<>(map.values());

		for (Product pdt : productList) {
			pdt.getAverageSellingPrice();
		}
		productList.sort((s1, s2) -> {
			int compare = Double.compare(s2.averageSellingPrice, s1.averageSellingPrice);
			if (compare == 0) {
				compare = (s1.productCode.compareTo(s2.productCode));
			}
			return compare;
		});
		for (Product pdt : productList) {
		sb.append(pdt);
		}
		System.out.print(sb);
	}

//		List<Product> productList = new ArrayList<>();
//		for (int i = 0; i < numberOfTransactions; i++) {
//			String transactionCode = reader.next();
//			String productCode = reader.next();
//			double sellingPrice = reader.nextDouble();
//			double quantity = reader.nextDouble();
//			boolean flag = false;
////			Transaction trans = new Transaction(transactionCode, productCode, sellingPrice, quantity);
////			if (productList.stream().filter(pro -> pro.productCode.equals(trans.productCode)).findFirst().isPresent()) {
////				productList.stream().filter(pro -> pro.productCode.equals(trans.productCode)).forEach(pro -> {
////					pro.totalSellingPrice += trans.sellingPrice * trans.quantity;
////					pro.totalQuantity += trans.quantity;
////				});
////			} else {
////				Product product = new Product(productCode);
////				product.totalQuantity = trans.quantity;
////				product.totalSellingPrice = trans.sellingPrice * trans.quantity;
////				productList.add(product);
////
////			}
//			for (Product pro : productList) {
//				if (pro.productCode.equals(productCode)) {
//					pro.totalSellingPrice += sellingPrice * quantity;
//					pro.totalQuantity += quantity;
//					flag = true;
//					pro.getAverageSellingPrice();
//					break;
//				}
//			}
//			if (!flag) {
//				Product product = new Product(productCode);
//				product.totalQuantity = quantity;
//				product.totalSellingPrice = sellingPrice * quantity;
//				product.getAverageSellingPrice();
//				productList.add(product);
//
//			}
////			if (!productList.stream().filter(pro -> pro.productCode.equals(productCode)).findFirst().isPresent()) {
////				Product product = new Product(productCode);
////				product.totalQuantity = quantity;
////				product.totalSellingPrice = sellingPrice * quantity;
////				productList.add(product);
////
////			} else {
////				for (Product pro : productList) {
////					if (pro.productCode.equals(productCode)) {
////						pro.totalSellingPrice += sellingPrice * quantity;
////						pro.totalQuantity += quantity;
////						break;
////					}
////				}
////			}
//		}
//		for (Product pdt : productList) {
//			pdt.getAverageSellingPrice();
//		}
//		productList.sort((s1, s2) -> {
//			int compare = Double.compare(s2.averageSellingPrice, s1.averageSellingPrice);
//			if (compare == 0) {
//				compare = (s1.productCode.compareTo(s2.productCode));
//			}
//			return compare;
//		});
//		for (Product pdt : productList) {
//			sb.append(pdt);
//		}
//		System.out.print(sb);
//	}

//	static class Transaction {
//		public String transactionCode;
//		public String productCode;
//		public double sellingPrice;
//		public double quantity;
//
//		public Transaction(String transactionCode, String productCode, double sellingPrice, double quantity) {
//			this.transactionCode = transactionCode;
//			this.productCode = productCode;
//			this.sellingPrice = sellingPrice;
//			this.quantity = quantity;
//		}
	//}

	static class Product {
		public String productCode;
		public double totalSellingPrice;
		public double totalQuantity;
		public double averageSellingPrice;

		Product(String productCode) {
			this.productCode = productCode;
		}

		public double getAverageSellingPrice() {
			averageSellingPrice = totalSellingPrice / totalQuantity;
			return averageSellingPrice;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(productCode).append(" ").append(Math.round(averageSellingPrice)).append("\n");
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
