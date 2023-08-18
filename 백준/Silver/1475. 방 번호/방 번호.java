import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(); // 방 번호

		int[] set = new int[10];

		String check = Integer.toString(n);
		for (int i = 0; i < check.length(); i++) {
			if (check.charAt(i) == '6') {
				set[9]++;
				continue;
			}
			set[check.charAt(i) - '0']++;
		}

		// 필요 세트 개수
		int max = 0;
		set[9] = set[9] / 2 + set[9] % 2;

		for (int i = 0; i < 10; i++) {
			if (set[i] > max) {
				max = set[i];
			}
		}

		System.out.println(max);

	}
}