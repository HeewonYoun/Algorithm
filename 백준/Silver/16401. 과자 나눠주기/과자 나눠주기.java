import java.io.*;
import java.util.*;

public class Main {
	
	static int M, N;
	static int[] cookies;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //조카 수
		N = Integer.parseInt(st.nextToken()); //과자 수
		
		cookies = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			cookies[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cookies);
		
		long start = 1;
		long end = cookies[N-1];
		
		while(start<=end) {
			long mid = (start + end)/2;
			
			if(solve(mid)) {
				start = mid + 1;
			} else {
				end = mid-1;
			}
		}
		System.out.println(start-1);
	}
	
	static boolean solve(long x) {
		long cur = 0;
		
		for(int i = 0; i<N; i++) {
			cur += cookies[i] / x;
		}
		return cur>=M;
	}
}