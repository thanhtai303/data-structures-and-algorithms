import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class FindSubarraysWithEqualSum {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		System.out.println(findSubarrays(new int[] {4,2,1,3,2,4
				}));
	}

	public static boolean findSubarrays(int[] nums) {
		HashMap<Integer, Integer> indexedMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) {
				indexedMap.put(i - 1, indexedMap.get(i - 1) + nums[i]);
				indexedMap.remove(i);
				break;
			}
			indexedMap.put(i, nums[i]);
			if (i > 0) {
				indexedMap.put(i, nums[i]);
				indexedMap.put(i - 1, indexedMap.get(i - 1) + nums[i]);
			}
		}
		System.out.println(indexedMap);
		List<Integer> indexList = new ArrayList<Integer>(indexedMap.values());
		System.out.println(indexList);
		for (int i = 0; i < nums.length; i++) {
			if (indexedMap.containsValue(indexedMap.get(i)&& indexedMap.))
				}
			
		
		return false;
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
