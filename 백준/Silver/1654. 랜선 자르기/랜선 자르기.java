import java.io.*;
import java.util.*;

public class Main {
	
	static int[] lan;
	static int K, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수 1<=K<=10000
 		N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수 1<=N<=1000000, K<=N
		
 		lan = new int[K];
 		for(int i = 0; i<K; i++) {
 			lan[i] = Integer.parseInt(br.readLine().trim());
 		}
		
 		Arrays.sort(lan);
 		
 		long start = 1;
 		long end = lan[K-1];
 		
 		while(start < end) {
 			long mid = (start+end+1)/2;
 			if(solve(mid)) { //N 이상이면
 				start = mid;
 			} else {
 				end = mid-1;
 			}
 		}
 		System.out.println(start);
	}
	
	static boolean solve(long x) {
		long cur = 0;
		for(int i = 0; i<K; i++) {
			cur += lan[i]/x;
		}
//		System.out.println(x+" "+cur);
		return (cur >= N);
	}
}
