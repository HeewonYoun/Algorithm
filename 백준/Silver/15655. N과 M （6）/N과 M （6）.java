import java.io.*;
import java.util.*;

public class Main {

	static int N, M;	
	static int[] num, sel;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		sel = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		c(0, 0);
	}
	
	static void c(int cnt, int idx) {
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = idx; i<N; i++) {
			sel[cnt] = num[i];
			c(cnt+1, i+1);
		}
	}
}
