import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N+1][M+1];

		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N+1][M+1];
		
		//상 (r-1, c)
		//좌 (r, c-1)
		//좌상(r-1, c-1)
		
		dp[1][1] = map[1][1];
		
		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<M+1; j++) {
				if(i == 1 && j == 1) continue;
				if(i == 1) dp[i][j] = dp[i][j-1] + map[i][j];//좌만가능
				else if(j == 1) dp[i][j] = dp[i-1][j] + map[i][j];//상만가능
				else {
					dp[i][j] = Math.max(dp[i-1][j] + map[i][j], dp[i][j-1] + map[i][j]);
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + map[i][j]);
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}
