import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	static int[][] board;
	static List<int[]> option = new ArrayList<int[]>();
	static int max = Integer.MIN_VALUE;
	static int[] sel = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j] == 0) {
					option.add(new int[] {i, j});
				}
			}
		}
		c(0,0);
		//0빈칸, 1벽, 2바이러스
		System.out.println(max);
	}
	
	static void c(int cnt, int s) {
		if(cnt == 3) {
			bfs(sel);
			return;
		}
		
		for(int i = s; i<option.size(); i++) {
			sel[cnt] = i;
			c(cnt+1, i+1);	
		}
	}
	
	static void bfs(int[] sel) {
//		System.out.println(Arrays.toString(sel));
		int[][] vis = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			for (int j = 0; j<M; j++) {
				vis[i][j] = -1;
				if(board[i][j] == 1) {
					vis[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i<3; i++) {
			vis[option.get(sel[i])[0]][option.get(sel[i])[1]] = 1; //벽으로
		}
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(vis[i][j] != -1) continue;
				if(board[i][j] == 2) {
					vis[i][j] = 2;
					q.offer(new int[] {i, j});
				}
				
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					
					for(int k = 0; k<4; k++) {
						int nx = cur[0] + dx[k];
						int ny = cur[1] + dy[k];
						
						if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
						if(vis[nx][ny] != -1) continue;
						if(board[nx][ny] == 0) {
							q.offer(new int[] {nx, ny});
							vis[nx][ny] = 2;
						}
					}
				}
				
			}
		}
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for (int j = 0; j<M; j++) {
				if(vis[i][j] == -1) cnt++;
			}
		}
		if(cnt > max) {
			max = cnt;
		}
	}
}
