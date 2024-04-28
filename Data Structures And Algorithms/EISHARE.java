import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EISHARE {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfStock = sc.nextInt();
		int numberOfHighestStock = sc.nextInt();
		HashMap<String, Stock> stockMap = new HashMap<>();
		for (int i = 0; i < numberOfStock; i++) {
			String command = sc.next();
			String stockCode = sc.next();
			double quantity = sc.nextDouble();
			double price = sc.nextDouble();
			if (stockMap.containsKey(stockCode)) {
				if (command.equals("B")) {
					stockMap.get(stockCode).getTotalBuy(quantity, price);
				} else
					stockMap.get(stockCode).getTotalSell(quantity, price);
			} else {
				Stock stock = new Stock(stockCode, quantity, price);
				if (command.equals("B")) {
					stock.getTotalBuy(quantity, price);
					stockMap.put(stockCode, stock);
				} else {
					stock.getTotalSell(quantity, price);
					stockMap.put(stockCode, stock);
				}
			}

		}

		List<Stock> stockList = new ArrayList<>(stockMap.values());
		for (Stock i : stockList) {
			i.getProfit();
		}
		stockList.sort((s1, s2) -> {
			int compare = Double.compare(s2.profit, s1.profit);
			if (compare == 0) {
				compare = s1.stockCode.compareTo(s2.stockCode);
			}
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		if (stockList.size() > numberOfHighestStock) {
			double temp = stockList.get(numberOfHighestStock).profit;
			for (int i = 0; i < numberOfStock; i++) {
				if (temp < stockList.get(i).profit) {
					sb.append(stockList.get(i));
				} else
					break;
			}
		} else
			for (int i = 0; i < stockList.size(); i++) {
				sb.append(stockList.get(i));
				if(i==numberOfHighestStock-1) {
					break;
				}
			}
		System.out.print(sb);

	}

	static class Stock {
		public String stockCode;
		public double quantity;
		public double price;
		public double totalSell;
		public double totalBuy;
		public double profit;

		public Stock(String stockCode, double quantity, double price) {
			this.stockCode = stockCode;
			this.quantity = quantity;
			this.price = price;
		}

		public void getTotalSell(double quantity, double price) {
			if (quantity <= this.quantity) {
				this.quantity -= quantity;
				this.totalSell += quantity * price - (quantity * price * 0.002);
			} else
				return;
		}

		public void getTotalBuy(double quantity, double price) {
			this.quantity += quantity;
			this.totalBuy += quantity * price+(quantity * price * 0.001);		
		}

		public void getProfit() {
			this.profit += totalSell - totalBuy;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(stockCode).append(" ").append(Math.round(profit)).append("\n");
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
