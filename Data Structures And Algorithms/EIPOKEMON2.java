import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;

public class EIPOKEMON2 {
	static InputReader sc = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfPokemons = sc.nextInt();
		List<Pokemon> pokemonList = new ArrayList<>();
		for (int i = 0; i < numberOfPokemons; i++) {
			String IDnumber = sc.next();
			String name = sc.next();
			double attack = sc.nextDouble();
			double defense = sc.nextDouble();
			double agility = sc.nextDouble();
			double luck = sc.nextDouble();
			double power = (attack + defense + agility + luck) / 4;
			Pokemon pokemon = new Pokemon(IDnumber, name, attack, defense, agility, luck, power);
			pokemonList.add(pokemon);

		}
		pokemonList.sort((s1, s2) -> {
			int compare = Double.compare(s2.power, s1.power);
			if (compare == 0)
				compare = Double.compare(s2.attack, s1.attack);
			if (compare == 0)
				compare = s1.IDnumber.compareTo(s2.IDnumber);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		int temp = 1;
		for (int i = 0; i < numberOfPokemons; i++) {
			if (i > 0 && pokemonList.get(i).power == pokemonList.get(i - 1).power) {
				sb.append("-").append(" ").append(pokemonList.get(i));
				temp++;
			} else if (i == 0) {
				sb.append(temp).append(" ").append(pokemonList.get(i));
				temp++;
			} else {
				sb.append(temp).append(" ").append(pokemonList.get(i));
				temp++;
			}
		}
		System.out.print(sb);
	}

	static class Pokemon {
		public String IDnumber;
		public String name;
		public double power;
		public double attack;
		public double defense;
		public double agility;
		public double luck;

		public Pokemon(String iDnumber, String name, double attack, double defense, double agility, double luck,
				double power) {
			this.IDnumber = iDnumber;
			this.name = name;
			this.attack = attack;
			this.defense = defense;
			this.agility = agility;
			this.luck = luck;
			this.power = power;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(IDnumber).append(" ").append(name).append(" ").append(Math.round(power)).append("\n");
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
