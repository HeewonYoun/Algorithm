import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken()); //행
		int C = Integer.parseInt(st.nextToken()); //열
		int T = Integer.parseInt(st.nextToken()); //T초
		
		int[][] map = new int[R][C];
		Queue<int[]> q = new ArrayDeque<int[]>();
		List<int[]> air = new ArrayList<int[]>();
	
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				//미세먼지
				if(map[i][j] > 1) {
					q.offer(new int[] {i,j,map[i][j]});
				}
				
				//공기청정기 위, 아래
				if(map[i][j] == -1) {
					air.add(new int[] {i,j});
				}
			}
		}
		
		air.sort(new Comparator<int[]>() { //위, 아래 .. 
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int[] dx = {-1,1,0,0}; //상하좌우
		int[] dy = {0,0,-1,1}; 
		
		for(int i = 0; i<T; i++) {

			//미세먼지 확산
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int A = cur[2]; //확산 모든 칸에서 동시에 
				
				int cnt = 0; //확산된 방향의 개수
				for(int j = 0; j<4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					
					//인접방향 공기청정기, 칸이 없으면 확산X
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;

					cnt++;
					map[nx][ny] += (int)(A/5);
					
				}
				
				//4방향 돌고 해당 위치 남은 미세먼지 양 바꾸기 A - (A/5)*확산방향 개수
				map[cur[0]][cur[1]] = map[cur[0]][cur[1]] - (A/5)*cnt;
			}
			
			//공기청정기 작동
			//윗부분 돌리기
			int[] cur = air.get(0);
			
			for(int j = cur[0]; j>0; j--) {
				if(j == cur[0]) map[j-1][0] = 0;
				else map[j][0] = map[j-1][0];
			}
			
			for(int j = 0; j<C-1; j++) {
				map[0][j] = map[0][j+1];
			}
			
			for(int j = 0; j<cur[0]; j++) {
				map[j][C-1] = map[j+1][C-1];
			}
			
			for(int j = C-1; j>0; j--) {
				if(j == 1) map[cur[0]][j] = 0;
				else map[cur[0]][j] = map[cur[0]][j-1];
			}
			
			///////////////////////////////////
			//아랫부분 돌리기
			cur = air.get(1);
			
			for(int j = cur[0]; j<R-1; j++) {
				if(j == cur[0]) map[j+1][0] = 0;
				else map[j][0] = map[j+1][0];
			}
			
			for(int j = 0; j<C-1; j++) {
				map[R-1][j] = map[R-1][j+1];
			}
			
			for(int j = R-1; j>cur[0]; j--) {
				map[j][C-1] = map[j-1][C-1];
			}
			
			for(int j = C-1; j>0; j--) {
				if(j == 1) map[cur[0]][j] = 0;
				else map[cur[0]][j] = map[cur[0]][j-1];
			}
			
			//다음 확산 전에 queue에 넣기
			for(int j = 0; j<R; j++) {
				for(int k = 0; k<C; k++) {
					if(map[j][k] > 1) {
						q.offer(new int[] {j,k,map[j][k]});
					}
				}
			}	
		}
		
		//방에 남아있는 미세먼지 양
		int result = 2;
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				result += map[i][j];
			}
		}
		
		System.out.println(result);
		
	}

}