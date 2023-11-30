import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] liquid = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquid);
		
		int result = Integer.MAX_VALUE;
		int start = 0;
		int end = N-1;
		int num1 = 0;
		int num2 = 0;
		
		while(start<end){
			int sum = liquid[start] + liquid[end];
			
			if(Math.abs(sum) < result) {
				result = Math.abs(sum); //절댓값
				num1 = liquid[start];
				num2 = liquid[end];
			}
			
			if(sum > 0) {
				end--;
			}else {
				start++;
			}
		}
		System.out.println(num1+ " "+num2);
	}
}