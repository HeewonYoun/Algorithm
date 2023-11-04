import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] map; //빙산 저장 배열
	static int[][] melt; //녹을 빙산 높이 저장 배열
	static int[][] vis; 
	
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		melt = new int[N][M];
		vis = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solution();
	}
	
	static void solution() {
		int year = 0; //년수 세기
		
		while(true) { 
			
			//dfs: 빙산 덩어리 세기
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(vis[i][j] == 0 && map[i][j] != 0) {// 방문 한적 없고, 빙산이면
						dfs(i, j);
						cnt++; //다 이어져 있으면 vis 다 체크되고 1개일 것 ..
					}
				}
			}
			
			if(cnt == 0) { //안나뉘고 다녹고 없는 경우
				System.out.println(0);
				break;
			}else if(cnt >= 2) { //빙산 나뉜 경우
				System.out.println(year);
				break;
			}
			
			melting(); //빙산 녹이기
			year++;
		}
	}
	
	static void dfs(int x, int y) {
		vis[x][y] = 1; //방문 체크
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) { //범위 안에 속하면
				if(map[nx][ny] == 0) {
					melt[x][y]++;
				}
				
				if(vis[nx][ny] == 0 && map[nx][ny] != 0) {
					dfs(nx, ny);
				}
			}
		}
		
	}
	
	static void melting() {
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				map[i][j] -= melt[i][j];
				
				if(map[i][j] < 0 ) {
					map[i][j] = 0;
				}
				
				//다음 해 때 계산하기 위해서 다시 초기화
				vis[i][j] = 0;
				melt[i][j] = 0;
			}
		}
	}

}
