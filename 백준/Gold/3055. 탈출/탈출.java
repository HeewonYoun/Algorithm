import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] board = new char[R][C];

		Queue<int[]> q1 = new ArrayDeque<>(); // 물
		Queue<int[]> q2 = new ArrayDeque<>(); // 도치
		int[][] vis1 = new int[R][C]; // 물
		int[][] vis2 = new int[R][C]; // 도치

		int dirDx = 0;
		int dirDy = 0;

		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				board[i][j] = tmp[j];

				if (tmp[j] == '*') {
					q1.offer(new int[] { i, j });
					vis1[i][j] = 1;
				}
				if (tmp[j] == 'S') {
					q2.offer(new int[] { i, j });
					vis2[i][j] = 1;
				}
				if (tmp[j] == 'D') {
					dirDx = i;
					dirDy = j;
				}
			}
		}
		
		//물 이동
		while (!q1.isEmpty()) {
			int cur[] = q1.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
				if(vis1[nx][ny] != 0) continue;
				if(board[nx][ny] == 'X')continue;
				if(board[nx][ny] == 'D')continue;
				
				q1.offer(new int[] {nx, ny});
				vis1[nx][ny] = vis1[cur[0]][cur[1]] + 1;
			}
		}
		//도치 이동
		while(!q2.isEmpty()) {
			int cur[] = q2.poll();
			
			if (cur[0] == dirDx && cur[1] == dirDy) {
				break;
			} 
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
				if(vis2[nx][ny] != 0) continue;
				if(board[nx][ny] == 'X')continue;
				if(vis1[nx][ny] != 0 && vis1[nx][ny] <= vis2[cur[0]][cur[1]] + 1) continue;
				
				q2.offer(new int[] {nx, ny});
				vis2[nx][ny] = vis2[cur[0]][cur[1]] + 1;
			}
		}
		if(vis2[dirDx][dirDy] == 0) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(vis2[dirDx][dirDy]-1);
		}
	}

}
