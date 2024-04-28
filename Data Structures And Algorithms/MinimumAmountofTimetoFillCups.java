import java.util.*;

public class MinimumAmountofTimetoFillCups {

	public static void main(String[] args) {
		System.out.println(fillCups(new int[] { 5, 0, 0

		}));

	}

	public static int fillCups(int[] amount) {
			int sum = (amount[0] + amount[1] + amount[2]);
			if (amount[0] == 0 || amount[1] == 0 || amount[2] == 0) {
				int max = amount[0];
				for (int i = 0; i < 3; i++) {
					if (amount[i] > max)
						max = amount[i];
				}
				return max;
			}
			return (sum / 2) + 1;
	}
}
