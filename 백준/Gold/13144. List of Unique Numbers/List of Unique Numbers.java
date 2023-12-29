import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //수열 길이
		int[] num = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int end = 0;
		long cnt = 0;
		int[] pos = new int[100003];
		
		for(int s = 1; s <= N; s++) {
			if(pos[num[s-1]] > 0) pos[num[s-1]]--;
			
			while(end + 1 <= N && pos[num[end+1]] <= 0) {
				pos[num[++end]]++;
			}
			
			cnt += (end - s + 1);
		}
		
		System.out.println(cnt);
	}

}