import java.io.*;
import java.util.*;

public class Main {

	static int P, Q;
	static Map<Long, Long> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken()); //An
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		map.put(0l, 1l);
		System.out.println(solve(N));
	
	}
	
	static long solve(long num) {
		
		if(num==0) return 1;
		if(map.containsKey(num)) return map.get(num);
		
		long num1 = num/P;
		long num2 = num/Q;
		
		map.put(num, solve(num1) + solve(num2));
		return map.get(num);
		
	}

}