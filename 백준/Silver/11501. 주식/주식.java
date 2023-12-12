import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] stock = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}
			
			//뒤에서부터 탐색
			int max = Integer.MIN_VALUE;
			long result = 0;
			for(int i = N-1; i>=0; i--) {
				if(stock[i] > max) {
					max = stock[i];
				} else {
					result += max - stock[i];
				}
			}
			System.out.println(result);
		}
	}
}