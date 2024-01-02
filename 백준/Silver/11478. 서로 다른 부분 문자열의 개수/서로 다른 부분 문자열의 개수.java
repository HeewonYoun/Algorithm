import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		char[] S2 = S.toCharArray();
		
		Map<String, Integer> map = new HashMap<>();
		for(int i = 1; i<=S2.length; i++) {
			//i: 구성 원소 개수
			for(int j = 0; j<=S2.length-i; j++) {
				String tmp = S.substring(j, j+i);
				if(map.containsKey(tmp)) {
					continue;
				} else {
					map.put(tmp, 1);
				}
			}
		}
		
		int count = map.size();
		System.out.println(count);
	}
}