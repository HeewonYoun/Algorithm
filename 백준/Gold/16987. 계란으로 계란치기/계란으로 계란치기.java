import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] egg;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 계란수
		egg = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken()); // 내구도
			egg[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}
		if (N == 1) {
			max = 0;
		} else {
			dfs(0, 0);
		}
		System.out.println(max);
	}

	static void dfs(int idx, int cnt) {
		if (idx == N) {
			if (cnt > max) {
				max = cnt;
			}
			return;
		}

		if (egg[idx][0] <= 0 || cnt == N-1) {// 해당 계란 내구도 0이면 넘어가기
			dfs(idx+1, cnt);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (idx == i || egg[i][0] <= 0) continue;

			egg[idx][0] -= egg[i][1];
			egg[i][0] -= egg[idx][1];

			if (egg[idx][0] <= 0) cnt++;
			if (egg[i][0] <= 0) cnt++;

			dfs(idx + 1, cnt);
			
			if (egg[idx][0] <= 0) cnt--;
			if (egg[i][0] <= 0) cnt--;

			egg[idx][0] += egg[i][1];
			egg[i][0] += egg[idx][1];

		}
	}
}
