import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EISTOCK {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfTransaction = sc.nextInt();
		HashMap<Integer, ProductStock> productStockMap = new HashMap<>();
		for (int i = 0; i < numberOfTransaction; i++) {
			String choosen = sc.next();
			int name = sc.nextInt();
			double quantity = sc.nextDouble();
			double price = sc.nextDouble();
			if (choosen.equals("+")) {
				if (productStockMap.containsKey(name)) {
					productStockMap.get(name).getImport(quantity, price);
				} else {
					ProductStock productStock = new ProductStock(name);
					productStock.getImport(quantity, price);
					productStockMap.put(name, productStock);
				}
			} else {
				if (productStockMap.containsKey(name)) {
					productStockMap.get(name).getExport(quantity, price);
				} else {
					ProductStock productStock = new ProductStock(name);
					productStock.getExport(quantity, price);
					productStockMap.put(name, productStock);
				}
			}
		}
		List<ProductStock> productStockList = new ArrayList<>(productStockMap.values());
		productStockList.sort((s1, s2) -> {
			int compare = Integer.compare(s1.name, s2.name);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		for (ProductStock i : productStockList) {
			if (i.exportAmount > 0 || i.importAmount > 0)
				sb.append(i);
		}
		System.out.println(sb);
	}

	static class ProductStock {
		public int name;
		public double totalQuantity;
		public double importAmount;
		public double exportAmount;

		public ProductStock(int name) {
			this.name = name;
		}

		public void getImport(double quantity, double price) {
			this.importAmount += quantity * price;
			this.totalQuantity += quantity;
		}

		public void getExport(double quantity, double price) {
			if (quantity > this.totalQuantity) {
				return;
			} else {
				this.exportAmount += quantity * price;
				this.totalQuantity -= quantity;
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(name).append(" ").append(Math.round(importAmount)).append(" ").append(Math.round(exportAmount))
					.append("\n");
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
