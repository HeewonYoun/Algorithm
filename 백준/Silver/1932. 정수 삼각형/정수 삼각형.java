import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] tri = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//합 최대 
		int[][] dp = new int[n+1][n+1];
		dp[0][0] = tri[0][0];
		
		//왼쪽 위 - [i-1][j-1]
		//오른쪽 위 - [i-1][j]
		
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<i+1; j++) {
				if(j == 0) dp[i][j] = dp[i-1][j] +tri[i][j]; 
				else if(j == i) dp[i][j] = dp[i-1][j-1] +tri[i][j]; 
				else {
					dp[i][j] = Math.max(dp[i-1][j-1] +tri[i][j], dp[i-1][j] +tri[i][j]);
				}
			}
		}
		
		int max = -1;
		for(int i = 0; i<n; i++) {
			if(dp[n-1][i] > max) max = dp[n-1][i];
		}
		System.out.println(max);
	}
}