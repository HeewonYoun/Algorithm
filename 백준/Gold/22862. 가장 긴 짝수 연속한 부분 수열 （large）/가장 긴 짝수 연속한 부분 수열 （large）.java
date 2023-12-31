import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] num = new int[S];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<S; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int count = 0;
		int result = 0;
		
		while(end < S) {
			if(count < K) {
				if(num[end] %2 == 1) count++;
				end++;
				result = Math.max(result, end-start-count);
			} else if(num[end]%2==0) {
				end++;
				result = Math.max(result, end-start-count);
			} else {
				if(num[start]%2 == 1) {
					count--;
				}
				start++;
			}
		}
		
		System.out.println(result);
		
	}

}