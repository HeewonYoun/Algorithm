import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] sort = new int[N]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sort[i] = num[i];
		}
		
		Arrays.sort(sort);

		HashMap<Integer,Integer> map = new HashMap<>();
		int count = 0;
		for(int i = 0; i<N; i++) {
			if(!map.containsKey(sort[i])) {
				map.put(sort[i], count);
				count++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			sb.append(map.get(num[i])).append(" ");
		}
		System.out.println(sb);
	}
}