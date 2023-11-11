import java.io.*;
import java.util.*;

public class Main {

	static int N, M;	
	static int[] num;
	static int[] sel;
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		sel = new int[M];
		vis = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		p(0);
	}
	
	static void p(int cnt) {
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(vis[i]) continue;
			sel[cnt] = num[i];
			vis[i] = true;
			p(cnt+1);
			vis[i] = false;
		}
	}
}
