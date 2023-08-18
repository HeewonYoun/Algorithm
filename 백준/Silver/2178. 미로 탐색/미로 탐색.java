import java.util.*;
import java.io.*;

/*
4 6
101111
101010
101011
111011
 */

public class Main {

	static class M {
		int x;
		int y;

		public M(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<M> q = new ArrayDeque<>();

		boolean[][] vis = new boolean[n][m];
		int[][] board = new int[n][m];
		int[] dx = { 1, -1, 0, 0 }; // 상하좌우
		int[] dy = { 0, 0, -1, 1 };

		for (int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				board[i][j] = tmp[j] - '0';
			}
		}

		
		q.offer(new M(0, 0)); // 시작
		vis[0][0] = true;
		M tmp;

		while (!q.isEmpty()) {
			tmp = q.poll();
			
			if (tmp.x == n-1 && tmp.y == m-1) {//(n,m) 도착하면 break
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if (nx >= n || nx < 0 || ny >= m || ny < 0) { // 범위 벗어나거나 이미 방문했으면
					continue;
				}
				if( vis[nx][ny] || board[nx][ny]==0) {
					continue;
				}
				q.offer(new M(nx, ny));
				vis[nx][ny] = true;
				board[nx][ny] = board[tmp.x][tmp.y] + 1; 
			}
		}
		System.out.println(board[n-1][m-1]);

	}

}
