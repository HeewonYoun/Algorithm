import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 0;
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) return;
			
			tc++;
			int[][] cave = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//잃을 수 밖에 없는 최소 금액
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2]-o2[2];
				}
			});
			
			int[][] vis = new int[N][N];
			for(int i = 0; i<N; i++) {
				Arrays.fill(vis[i], Integer.MAX_VALUE);
			}
			
			q.offer(new int[]{0,0,cave[0][0]});
			vis[0][0] = cave[0][0];
			
			while(!q.isEmpty()) {
				int cur[] = q.poll();
				int cost = cur[2];
				
				if(cur[0] == N-1 && cur[1] == N-1) break;
				
				for(int i = 0; i<4; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if(vis[nx][ny] > vis[cur[0]][cur[1]] + cave[nx][ny]) {
						q.offer(new int[] {nx, ny, vis[cur[0]][cur[1]] + cave[nx][ny]});
						vis[nx][ny] = vis[cur[0]][cur[1]] + cave[nx][ny];
					}
				}
			}
			System.out.println("Problem "+tc+": "+vis[N-1][N-1]);
		}
	}
}