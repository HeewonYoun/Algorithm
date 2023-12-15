import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int n = Integer.parseInt(st.nextToken()); // 2 <= n <= 1000
		int m = Integer.parseInt(st.nextToken());
		
		long[] num = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		
		for(int i = 0; i<m; i++) { //합체!
			Arrays.sort(num); //오름차순 정렬
			
			//앞에 숫자 두개 뽑아서 더한 후 덮어쓰기
			long num1 = num[0];
			long num2 = num[1];
			
			long sum = num1 + num2;
			
			num[0] = sum;
			num[1] = sum;
		}
		
		//수 모두 더하기
		long result = 0;
		for(int i = 0; i<n; i++) {
			result += num[i];
		}
		System.out.println(result);
	}
}