import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		
		long result = Integer.MAX_VALUE;
		
		while(st.hasMoreTokens()) {
			int sum = 0;
			
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			
			while(st2.hasMoreTokens()) {
				sum += Integer.parseInt(st2.nextToken());
			}
			
			if(result == Integer.MAX_VALUE) {
				result = sum;
			}else {
				result -= sum;
			}
		}
		System.out.println(result);		
	}
}