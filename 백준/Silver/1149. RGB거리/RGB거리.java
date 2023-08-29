import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] cc = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];

		int sum = 0;

		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cc[i][0] = Integer.parseInt(st.nextToken()); // 빨
			cc[i][1] = Integer.parseInt(st.nextToken()); // 초
			cc[i][2] = Integer.parseInt(st.nextToken()); // 파
		}

		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][2]+cc[i][0], dp[i-1][1]+cc[i][0]);
			dp[i][1] = Math.min(dp[i-1][2]+cc[i][1], dp[i-1][0]+cc[i][1]);
			dp[i][2] = Math.min(dp[i-1][1]+cc[i][2], dp[i-1][0]+cc[i][2]);
		}
		
		int res = Math.min(Math.min(dp[N][0],dp[N][1]), dp[N][2]);
		System.out.println(res);
		
	}

}
