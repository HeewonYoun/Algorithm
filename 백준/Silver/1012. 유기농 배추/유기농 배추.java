import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[][] g = new int[N][M];

			int K = Integer.parseInt(st.nextToken()); // 배추 심어져 있는 위치 개수
			int x, y;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				g[y][x] = 1; // 배추위치 1
			}
			//////////////////////////////입력완료
			
			// 인접한 블록이 몇개인지 ..
			int cnt = 0;

			Queue<int[]> q = new ArrayDeque<int[]>();
			boolean[][] vis = new boolean[N][M];
			int[] dx = { -1, 0, 1, 0 }; // 상우하좌
			int[] dy = { 0, 1, 0, -1 };

			int nx, ny;
			int now[];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (g[i][j] == 1 && vis[i][j] == false) {
						cnt++;
						vis[i][j] = true;
						q.offer(new int[] { i, j });
					}

					while (!q.isEmpty()) {
						now = q.poll();

						for (int k = 0; k < 4; k++) {
							nx = now[0] + dx[k];
							ny = now[1] + dy[k];

							if (nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;
							if (vis[nx][ny] || g[nx][ny] == 0)
								continue;

							q.offer(new int[] { nx, ny });
							vis[nx][ny] = true;

						}

					}

				}
			}

			System.out.println(cnt);
		}

	}

}
