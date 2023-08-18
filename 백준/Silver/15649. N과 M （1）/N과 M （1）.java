import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] map; // N까지 자연수
	static int[] nums;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // N까지 자연수
		M = sc.nextInt(); // M개
		map = new int[N + 1];
		nums = new int[M];
		v = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			map[i] = i;
		}

		perm(0);
	}

	static void perm(int n) {
		// 종료
		if (n == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		// 실행
		for (int i = 1; i < N + 1; i++) {
			if (v[i]) {
				continue;
			}
			nums[n] = map[i];
			v[i] = true;

			// 재귀
			perm(n + 1);
			v[i] = false;
		}
	}
}