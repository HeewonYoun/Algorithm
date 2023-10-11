import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken()); //상범빌딩 층 수
			int R = Integer.parseInt(st.nextToken()); //한 층의 행
			int C = Integer.parseInt(st.nextToken()); //열의 개수
			
			if(L == 0 && R == 0 && C == 0) break;
			
			int[] dx = {-1, 1, 0, 0, 0, 0}; //상하좌우 위아래
			int[] dy = {0, 0, -1, 1, 0, 0}; 
			int[] dz = {0, 0, 0, 0, -1, 1};
			
			char[][][] map = new char[L][R][C];
			int[] end = new int[3];
			Queue<int[]> q = new ArrayDeque<int[]>();
			int[][][] vis = new int[L][R][C];
			
			for(int i = 0; i<L; i++) {
				for(int j = 0; j<R; j++) {
					char[] tmp = br.readLine().toCharArray();
					for(int k = 0; k<C; k++) {
						map[i][j][k] = tmp[k];
						
						if(tmp[k] == 'S') { //시작지점
							q.offer(new int[] {i, j, k});
							vis[i][j][k] = 1;
						}
						if(tmp[k] == 'E') { //출구
							end[0] = i;
							end[1] = j;
							end[2] = k;
						} 
					}
				}
				br.readLine();
			}
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				if(cur[0] == end[0] && cur[1] == end[1] && cur[2] == end[2]) break;
				
				for(int i = 0; i<6; i++) {
					int nz = cur[0] + dz[i];
					int nx = cur[1] + dx[i];
					int ny = cur[2] + dy[i];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L) continue;
					if(vis[nz][nx][ny] != 0) continue;
					if(map[nz][nx][ny] == '#') continue; //지나갈 수 없는 칸
					
					q.offer(new int[] {nz, nx, ny});
					vis[nz][nx][ny] = vis[cur[0]][cur[1]][cur[2]] + 1;
				}
			}
			
			result = vis[end[0]][end[1]][end[2]]-1;
			if(result == -1) {
				System.out.println("Trapped!");
			}else {
				System.out.printf("Escaped in %d minute(s).\n",result);
			}
		}
	}
}