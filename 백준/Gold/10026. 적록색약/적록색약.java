import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] pic = new char[N][N];
		char[] tmp;
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				pic[i][j] = tmp[j];
			}
		}

		Queue<int[]> q = new ArrayDeque<int[]>(); // 아닌 사람일 때
		Queue<int[]> rgq = new ArrayDeque<int[]>(); // 적록색약인 사람일 때

		int cnt = 0; // 아닌 사람일 때
		int rgcnt = 0; // 적록색약인 사람일 때

		int[] dx = { -1, 0, 1, 0 }; // 상우좌하
		int[] dy = { 0, 1, 0, -1 };

		boolean[][] vis = new boolean[N][N];
		boolean[][] rgvis = new boolean[N][N];

		int[] c = new int[2];
		int nx, ny;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (vis[i][j] == false) { // 적록색약이 아닌사람
					q.offer(new int[] { i, j });
					vis[i][j] = true;
					cnt++;
				}

				while (!q.isEmpty()) {
					c = q.poll();

					for (int k = 0; k < 4; k++) {
						nx = c[0] + dx[k];
						ny = c[1] + dy[k];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if (vis[nx][ny]) continue;
						if (pic[c[0]][c[1]] == pic[nx][ny]) { // 현재위치의 색과 다음위치의 색이 같을 때
							q.offer(new int[] { nx, ny });
							vis[nx][ny] = true;
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (rgvis[i][j] == false) {// 적록색약인 사람
					rgq.offer(new int[] { i, j });
					rgvis[i][j] = true;
					rgcnt++;
				}

				while (!rgq.isEmpty()) {
					c = rgq.poll();

					for (int k = 0; k < 4; k++) {
						nx = c[0] + dx[k];
						ny = c[1] + dy[k];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N)	continue;
						if (rgvis[nx][ny]) continue;
						if (pic[c[0]][c[1]] == pic[nx][ny] || (pic[c[0]][c[1]] == 'R' && pic[nx][ny] == 'G')
								|| (pic[c[0]][c[1]] == 'G' && pic[nx][ny] == 'R')) {
							rgq.offer(new int[] { nx, ny });
							rgvis[nx][ny] = true;
						}
					}
				}
			}
		}
		System.out.println(cnt + " " + rgcnt); // 결과 출력
	}
}
