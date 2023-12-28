import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //N개 수
		int M = Integer.parseInt(st.nextToken()); //M 이상이면서 가장 작은 차이
		
		int[] num = new int[N];
		
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine().trim());
		}
		
		//정렬
		Arrays.sort(num);
		
		int min = Integer.MAX_VALUE;
		
		int start = 0;
		int end = 1;
		
		while(end < N) {
			if(num[end] - num[start] < M) {
				end++;
			} else if(num[end] - num[start] > M) {
				min = Math.min(num[end] - num[start], min);
				start++;
			} else { //같을때
				min = M;
				break;
			}
		}
		System.out.println(min);
	}
}