import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<int[]> s = new Stack<>();
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int check = Integer.parseInt(st.nextToken());
			if(check == 1) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				s.push(new int[] {A, T});
			}
			
			if(!s.isEmpty()) {
				int[] tmp = s.pop();
				
				tmp[1]--;
				if(tmp[1] == 0) {
					result += tmp[0];
				}else {
					s.push(tmp);
				}
			}
		}
		
		System.out.println(result);
	}
}
