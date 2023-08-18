import java.io.*;
import java.util.*;

/*
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1
*/

public class Main {

	public static class B {
		int x;
		int y;

		public B(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<B> q = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 세로
		int m = Integer.parseInt(st.nextToken()); // 가로

		int[] dx = { 1, -1, 0, 0 }; // 상하좌우
		int[] dy = { 0, 0, -1, 1 };

		int[][] board = new int[n][m];
		boolean[][] vis = new boolean[n][m]; // 방문체크

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0; // 그림 개수
		int max = 0; // 가장 넓은 그림의 넓이

		B current;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0 || vis[i][j]) {
					continue;
				}
				int size = 0;
				q.offer(new B(i, j));
				vis[i][j] = true;
				count++;
				size++;

				
				while (!q.isEmpty()) {
					current = q.poll();
					
					
					for (int k = 0; k < 4; k++) {
						int nx = current.x + dx[k];
						int ny = current.y + dy[k];

						if (nx >= n || nx < 0 || ny >= m || ny < 0) {
							continue; // 보드 범위에서 벗어나면
						}

						if (board[nx][ny] == 0 || vis[nx][ny]) {
							continue; // 이미 방문했거나 색칠 안된 경우
						}

						vis[nx][ny] = true; // 방문한 곳 표시
						q.offer(new B(nx, ny));
						size++;
					}
				}
				if (size > max) {
					max = size;
				}
			}
		}
		System.out.println(count);
		System.out.println(max);

	}
}
