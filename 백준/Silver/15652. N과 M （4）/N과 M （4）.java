import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[M];
		
		c(1, 0);
	}

	static void c(int start, int cnt) {
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start ; i<N+1; i++) {
			sel[cnt] = i;
			c(i, cnt+1);
		}
	}
}