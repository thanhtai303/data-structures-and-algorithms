import java.util.*;

public class VocativePronouns {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int age = sc.nextInt();
		String gender = sc.next();

		Person.age = age;
		Person.gender = gender;
		Person.result();

	}

	static class Person {
		public static String gender;
		public static int age;

		public static void result() {
			if (age <= 5) {
				System.out.println("Be");
				return;
			}
			if (age <= 20) {
				System.out.println("Em");
				return;
			}
			if (age <= 35 && gender.equals("Nam")) {
				System.out.println("Anh");
				return;
			}
			if (age <= 35 && gender.equals("Nu")) {
				System.out.println("Chi");
				return;
			}
			if (age <= 60 && gender.equals("Nam")) {
				System.out.println("Chu");
				return;
			}
			if (age <= 60 && gender.equals("Nu")) {
				System.out.println("Co");
				return;
			}
			if (age > 60 && gender.equals("Nam")) {
				System.out.println("Ong");
				return;
			}
			if (age > 60 && gender.equals("Nu")) {
				System.out.println("Ba");
				return;
			}

		}
	}
}
