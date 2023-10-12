import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static int[][][] vis;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		
		vis = new int[2][N][M]; //벽 부순 경우, 안부순 경우 2가지로 방문체크
		bfs();
		
	}
	
	//0 이동가능, 1 이동 불가 벽
	//(0,0)~(N,M) - 시작칸, 끝칸 포함
	//벽 한개까지 부수고 이동 가능
	
	static void bfs() {
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {0,0,0});
		vis[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == N-1 && cur[1] == M-1) {
				System.out.println(vis[cur[2]][cur[0]][cur[1]]);
				System.exit(0);
			}
			
			for(int i = 0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(vis[cur[2]][nx][ny] != 0) continue; //방문한경우
				
				if(map[nx][ny] == 1 && cur[2]==0) {//주위가 벽이고 cnt가 0이면
					//벽 부수는 경우
					q.offer(new int[] {nx, ny, 1});
					vis[1][nx][ny] = vis[0][cur[0]][cur[1]] + 1;
					
				}else if(map[nx][ny] != 1){
					q.offer(new int[] {nx, ny, cur[2]});
					vis[cur[2]][nx][ny] = vis[cur[2]][cur[0]][cur[1]] + 1;
				}
			}
		}
		
		System.out.println(-1);
	}
}