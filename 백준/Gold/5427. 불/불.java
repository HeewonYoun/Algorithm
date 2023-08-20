import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			char[][] board = new char[h][w];
			Queue<int[]> sq = new ArrayDeque<int[]>();
			Queue<int[]> fq = new ArrayDeque<int[]>();
			
			int[][] svis = new int[h][w];
			int[][] fvis = new int[h][w];
			for(int i = 0; i<h; i++) {
				for(int j = 0; j<w; j++) {
					svis[i][j] = -1;
					fvis[i][j] = -1;
				}
			}
			
			
			char[] tmp;
			for (int i = 0; i < h; i++) {
				tmp = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					board[i][j] = tmp[j];
					
					if(tmp[j] == '@') {
						sq.offer(new int[] {i,j});
						svis[i][j] = 0;
					}
					
					if(tmp[j] == '*') {
						fq.offer(new int[] {i, j});
						fvis[i][j] = 0;
					}
				}
			}
			
			int[] dx = {-1, 0, 1, 0}; //상우하좌
			int[] dy = {0, 1, 0, -1};
			//불
			int nx, ny;
			int c[];
			while(!fq.isEmpty()) {
				c = fq.poll();
				
				for(int i = 0; i<4; i++) {
					nx = c[0] + dx[i];
					ny = c[1] + dy[i];
					
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					if(fvis[nx][ny] != -1 || board[nx][ny] == '#') continue;
					
					fq.offer(new int[] {nx, ny});
					fvis[nx][ny] = fvis[c[0]][c[1]] + 1;
 				}
			}
			
			//상근
			int result = -1;
			while(!sq.isEmpty()) {
				c = sq.poll();
				
				if(c[0] == 0 || c[0] == h-1 || c[1] == 0 ||  c[1] == w-1) {//탈출했으면 break;
//					System.out.println(svis[c[0]][c[1]]);
					result = svis[c[0]][c[1]] + 1;
					break;
				}
				
				for(int i = 0; i<4; i++) {
					nx = c[0] + dx[i];
					ny = c[1] + dy[i];
					
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					if(svis[nx][ny] != -1 || board[nx][ny] != '.') continue;

					if(fvis[nx][ny] == -1 || fvis[nx][ny] > svis[c[0]][c[1]]+1) {// 불이랑 시간 비교
						sq.offer(new int[] {nx, ny});
						svis[nx][ny] = svis[c[0]][c[1]] + 1;
					}
 				}
			}

			if(result == -1) {
				System.out.println("IMPOSSIBLE");
			}
			else {
				System.out.println(result);
			}
		}
	}
}
