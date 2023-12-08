import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 3]; // 연산 횟수 저장
		int[] memo = new int[N + 3]; // 연산 기록 저장

		dp[1] = 0;
		dp[2] = 1;
		memo[2] = 1;

		if (N >= 3) {
			dp[3] = 1;
			memo[3] = 1;
		}

		for (int i = 4; i <= N; i++) {
			int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE, c3 = Integer.MAX_VALUE;
			// 2로 나누어 질 때
			if (i % 2 == 0) {
				c1 = 1 + dp[i / 2];
				memo[i] = i / 2;
				dp[i] = c1;
			}

			// 3으로 나누어 질 때
			if (i % 3 == 0) {
				c2 = 1 + dp[i / 3];
				if (Math.min(c1, c2) == c2) {
					memo[i] = i / 3;
					dp[i] = c2;
				}
			}

			c3 = 1 + dp[i - 1];
			if (Math.min(c1, Math.min(c2, c3)) == c3) {
				memo[i] = i - 1;
				dp[i] = c3;
			}
		}
		System.out.println(dp[N]);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(N + " ");
		for (int i = N; i > 1;) {
			bw.write(memo[i] + " ");
			i = (int) memo[i];
		}
		bw.flush();
	}
}