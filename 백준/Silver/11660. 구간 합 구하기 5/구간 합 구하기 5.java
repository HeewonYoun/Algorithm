import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken()); // 표 크기
		int m = Integer.parseInt(st.nextToken()); // 합 구하는 횟수

		int[][] num = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				num[i][j] = num[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());// 시작
			int sy = Integer.parseInt(st.nextToken()); // 시작
			int ex = Integer.parseInt(st.nextToken()); // 끝
			int ey = Integer.parseInt(st.nextToken()); // 끝

			int sum = 0;

			for (int j = sx; j < ex + 1; j++) {
				sum += num[j][ey] - num[j][sy - 1];
			}
			
			sb.append(sum+"\n");
			
		}
		
		System.out.println(sb);
	}
}