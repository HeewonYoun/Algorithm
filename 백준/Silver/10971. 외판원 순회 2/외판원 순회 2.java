import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static boolean[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 한 도시에서 출발 ~ N개 도시 ~ 다시 원래 도시
		for (int i = 0; i < N; i++) {
			vis = new boolean[N];
			vis[i] = true;
			dfs(i, i, 0);
		}
		System.out.println(min);
	}

	static void dfs(int start, int idx, int sum) {
		if (allVisited()) {
			if (map[idx][start] != 0) {
				sum += map[idx][start];
				if (sum < min) {
					min = sum;
				}
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (vis[i])continue;
			if (map[idx][i] != 0) {
				vis[i] = true;
				dfs(start, i, sum + map[idx][i]);
				vis[i] = false;
			}
		}
	}

	static boolean allVisited() {
		for (int i = 0; i < N; i++) {
			if (!vis[i])
				return false;
		}
		return true;
	}
}
