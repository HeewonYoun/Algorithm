import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //수열길이
		int S = Integer.parseInt(st.nextToken()); //연속된 수들 부분합 중 S이상이 되는것 중 짧은것
		
		int[] num = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}	
		
		int len = Integer.MAX_VALUE; 
		
		int start = 0;
		int end = 0;
		int sum = 0; //start~end 앞까지의 합
		
		while(start <= end && end <= N) {
			if(sum >= S) {
				int tmp = end - start;
				len = Math.min(tmp, len);
				sum -= num[start++]; //시작칸 한칸 오른쪽으로 줄이기
				
			} else if(sum < S) {
				sum += num[end++]; //끝값 한칸 늘리기
			}
		}
		if(len == Integer.MAX_VALUE) len = 0;
		System.out.println(len);
	}
}