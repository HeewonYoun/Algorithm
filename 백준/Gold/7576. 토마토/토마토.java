import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 상자 가로칸 수
		int N = Integer.parseInt(st.nextToken()); // 상자 세로칸 수

		Queue<int[]> q = new ArrayDeque<>();

		int[][] box = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dx = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
		int[] dy = { 0, 1, 0, -1 };
		boolean[][] vis = new boolean[N][M];

		int x, y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					q.offer(new int[] { i, j });
					vis[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || vis[nx][ny])
					continue;
				if (box[nx][ny] == -1)
					continue;
				if (box[nx][ny] == 0) {
					box[nx][ny] = 1 + box[x][y];
					vis[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}

//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(box[i]));
//		}

		int result = 0;
		// 배열에 0이 존재하면 -1 출력
		end: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					result = 0;
					break end;
				}

				if (box[i][j] > result)
					result = box[i][j];
			}
		}
		System.out.println(result - 1);
	}

}
