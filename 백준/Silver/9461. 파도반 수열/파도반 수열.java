import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		long[] p = new long[101];
		
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 1 <= N <= 100
			
			for(int i = 5; i<=N; i++) {
				p[i] = p[i-5] +p[i-1];
			}
			System.out.println(p[N]);
		}
	}
}