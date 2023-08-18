import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수
		int m = sc.nextInt(); // 합 구하는 횟수

		int[] num = new int[n + 1];
		num[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			num[i] = num[i-1] + sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt(); // 시작
			int end = sc.nextInt(); // 끝
			int sum = 0;

			sum = num[end] - num[start - 1];

			System.out.println(sum);
		}
	}
}