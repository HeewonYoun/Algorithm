import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, K;
	static int[][] map;
	static int[][][] vis;
	static Queue<int[]> q;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 벽을 K까지 부수고 이동 가능 (1<=K<=10)

		map = new int[N][M];
		vis = new int[K+1][N][M];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		bfs();
	}
	
	static void bfs() {
		q = new ArrayDeque<int[]>();
		q.offer(new int[] {0,0,0}); //벽뿌, x, y
		vis[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int cnt = cur[0];
			int cx = cur[1];
			int cy = cur[2];
			
//			System.out.println("헉 "+cx +" "+cy +" "+cnt);
			
			if(cx == N-1 && cy == M-1) {
				System.out.println(vis[cnt][cx][cy]);
				return;
			}
			
			for(int i = 0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
		
				if(vis[cnt][nx][ny] != 0) continue;
				
				if(map[nx][ny] == 1 && cnt < K) { //벽이고 벽뿌 횟수 안넘었으면
					q.offer(new int[] {cnt+1, nx, ny});
					vis[cnt+1][nx][ny] = vis[cnt][cx][cy] + 1;
					
				} else if (map[nx][ny] == 0) { //벽이 아닌 경우
					q.offer(new int[] {cnt, nx, ny});
					vis[cnt][nx][ny] = vis[cnt][cx][cy] + 1;
				}
			}
		}
		System.out.println(-1);
		System.exit(0);
	}
}
