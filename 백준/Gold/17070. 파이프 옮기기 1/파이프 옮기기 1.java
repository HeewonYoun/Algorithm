import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static int[][] dx = {{0,0,1}, {0,1,1}, {0,1,1}}; // 가로, 세로, 대각선 순서
	static int[][] dy = {{1,0,1}, {0,0,1}, {1,0,1}};
	static int[] dir = {0, 1, 2};
	static int cnt = 0;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//(0,0),(0,1) ~ (N-1, N-1)
		//dir- 0:가로 1:세로 2:대각선
		d(0,1,0);
		System.out.println(cnt); 
	}
	
	static void d(int cx, int cy, int dir) {
		if(cx == N-1 && cy == N-1) {
			cnt++;
			return;
		}
		
		for(int i =0; i<3; i++) {
			int nx = cx + dx[dir][i];
			int ny = cy + dy[dir][i];
			int ndir = i;
			
			if(ndir == 2) { //대각선인 경우 3칸 차지 (벽인지 확인해야함)
				//(nx, ny)의 왼쪽, 위쪽 확인
				int cx1 = nx;
				int cy1 = ny-1;
				int cx2 = nx-1;
				int cy2 = ny;
				
				if(cx1 < 0 || cx1 >= N || cy1 < 0 || cy1 >= N) continue;
				if(cx2 < 0 || cx2 >= N || cy2 < 0 || cy2 >= N) continue;
				if(map[cx1][cy1] == 1 || map[cx2][cy2] == 1) continue;
			}
			
			if(nx == cx && ny == cy) continue;
			if(nx >= N || ny >= N) continue;
			if(map[nx][ny] == 1) continue; //벽
			
			d(nx, ny, ndir);
			
		}
		return;
	}
}