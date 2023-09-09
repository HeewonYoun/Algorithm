import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int[] num;
	static int[] sel;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N+1];
		sel = new int[M];
		for(int i = 1; i<N+1; i++) {
			num[i] = i;
		}
		
		dfs(0);
		System.out.println(sb);
	}
	
	static void dfs(int cnt) {
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i<N+1; i++) {
			sel[cnt] = num[i];
			dfs(cnt+1);
		}
	}
}
