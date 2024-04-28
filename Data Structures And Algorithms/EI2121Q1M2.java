import java.util.*;

public class EI2121Q1M2 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		HashMap<Integer, Integer> staffs = new HashMap<>();
		int numberOfStaffs = sc.nextInt();
		for (int i = 0; i < numberOfStaffs; i++) {
			int staff = sc.nextInt();
			if (staffs.containsKey(staff)) {
				staffs.replace(staff, staffs.get(staff) + 1);
			} else
				staffs.put(staff, 1);
		}
		List<Integer> staffsList = new ArrayList<>(staffs.keySet());
		staffsList.sort((s1, s2) -> s1 - s2);
		for (Integer i:staffsList) {
			sb.append(i).append(" ").append(staffs.get(i)).append("\n");
		}
		System.out.println(sb);
	}

}
