import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIUGENSHIN {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfAttacks = sc.nextInt();
		int numberOfCharacters = sc.nextInt();
		int k = sc.nextInt();
		HashMap<String, Character> characterMap = new HashMap<>();
		Boss boss = new Boss();
		for (int i = 0; i < numberOfCharacters; i++) {
			String name = sc.next();
			double attackDamage = sc.nextDouble();
			double criticalDamage = sc.nextDouble();
			String elementStyle = sc.next();
			Character character = new Character(name, attackDamage, criticalDamage, elementStyle);
			characterMap.put(name, character);
		}
		for (int i = 0; i < numberOfAttacks; i++) {
			String name = sc.next();
			int command = sc.nextInt();
			double coefficient = boss.getAttack(characterMap.get(name).elementStyle);
			characterMap.get(name).getAttack(command, coefficient);
		}
		List<Character> characterList = new ArrayList<>(characterMap.values());
		StringBuilder sb = new StringBuilder();
		for (Character i : characterList) {
			i.getTotalDamage();
		}
		characterList.sort((s1, s2) -> {
			int compare = Double.compare(s2.totalDamage, s1.totalDamage);
			if (compare == 0)
				compare = s1.name.compareTo(s2.name);
			return compare;
		});
		if (characterList.size() > k) {
			double temp = characterList.get(k - 1).totalDamage;
			for (int i = 0; i < characterList.size(); i++) {
				if (characterList.get(i).totalDamage>= temp) {
					sb.append(characterList.get(i));
				} else
					break;
			}
		} else
			for (int i = 0; i < characterList.size(); i++) {
				sb.append(characterList.get(i));
				if (i == k)
					break;
			}
		System.out.println(sb);
	}

	static class Boss {
		public String elementStyle;
		public boolean applyElement;

		public double getAttack(String elementStyle) {
			if (this.elementStyle == null) {
				this.elementStyle = elementStyle;
				this.applyElement = true;
			} else if (this.elementStyle.equals(elementStyle)) {
				this.elementStyle = elementStyle;
				applyElement = true;
			} else if (this.elementStyle.equals("Pyro") && elementStyle.equals("Hydro")
					|| this.elementStyle.equals("Hydro") && elementStyle.equals("Pyro")) {
				this.elementStyle = null;
				this.applyElement = false;
				return 1;
			} else if (this.elementStyle.equals("Pyro") && elementStyle.equals("Cryo")
					|| this.elementStyle.equals("Cryo") && elementStyle.equals("Pyro")) {
				this.elementStyle = null;
				this.applyElement = false;
				return 0.5;
			} else if (this.elementStyle.equals("Pyro") && elementStyle.equals("Electro")
					|| this.elementStyle.equals("Electro") && elementStyle.equals("Pyro")) {
				this.elementStyle = null;
				this.applyElement = false;
				return 0.3;
			} else if (this.elementStyle.equals("Hydro") && elementStyle.equals("Cryo")
					|| this.elementStyle.equals("Cryo") && elementStyle.equals("Hydro")) {
				this.elementStyle = null;
				this.applyElement = false;
				return 0.2;
			} else if (this.elementStyle.equals("Hydro") && elementStyle.equals("Electro")
					|| this.elementStyle.equals("Electro") && elementStyle.equals("Hydro")) {
				this.elementStyle = null;
				this.applyElement = false;
				return 0.3;
			} else if (this.elementStyle.equals("Cryo") && elementStyle.equals("Electro")
					|| this.elementStyle.equals("Electro") && elementStyle.equals("Cryo")) {
				this.elementStyle = null;
				this.applyElement = false;
				return 0.3;
			}
			return 0;
		}
	}

	static class Character {
		public String name;
		public double attacDamage;
		public double criticalDamage;
		public String elementStyle;
		List<Double> attackList = new ArrayList<Double>();
		public double totalDamage;

		public Character(String name, double attacDamage, double criticalDamage, String elementStyle) {
			this.name = name;
			this.attacDamage = attacDamage;
			this.criticalDamage = criticalDamage;
			this.elementStyle = elementStyle;
		}

		public void getAttack(int i, double coefficient) {
			if (i == 0) {
				attackList.add(attacDamage * (1 + coefficient));
			} else
				attackList.add(criticalDamage * (1 + coefficient));
		}

		public double getTotalDamage() {
			if (attackList.size() == 0) {
				return 0;
			}
			for (Double i : attackList) {
				totalDamage += i;
			}
			return totalDamage;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.name).append(" ").append(Math.round(totalDamage)).append("\n");
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
