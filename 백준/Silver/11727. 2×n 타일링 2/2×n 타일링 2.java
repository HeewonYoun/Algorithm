import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;
		
		for(int i = 4; i<n+1; i++) {
			dp[i] = (dp[i-1]+ dp[i-2]*2)%10007;
		}
		
		System.out.println(dp[n]);
		
	}

}
