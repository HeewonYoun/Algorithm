import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}; //오1 오2 오3 오4 왼4 왼3 왼2 왼1
		int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		int[] start = new int[2];
		int[] end = new int[2];
		
		for(int t = 0; t<tc; t++) {
			int l = Integer.parseInt(br.readLine());
			int[][] board = new int[l][l];
			
			Queue<int[]> q = new ArrayDeque<int[]>();
			int[][] vis = new int[l][l]; //방문체크
			
			//방문체크 배열 -1로 초기화
			for(int i = 0; i<l; i++) {
				for(int j = 0; j<l; j++) {
					vis[i][j] = -1; // 미방문 -1
				}
			}
			
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken()); //나이트 현재 x좌표
			start[1] = Integer.parseInt(st.nextToken()); //나이트 현재 y좌표
			
			q.offer(new int[] {start[0], start[1]});
			vis[start[0]][start[1]] = 0; //현재 다음칸부터 이동한거 카운트 

			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken()); //나이트 이동하려는 x좌표
			end[1] = Integer.parseInt(st.nextToken()); //나이트 이동하려는 y좌표
			
			int[] c;
			int nx, ny;
			while(!q.isEmpty()) {
				c = q.poll();
				
				if(c[0] == end[0] && c[1] == end[1]) {
					System.out.println(vis[c[0]][c[1]]);
				}
				
				for(int i = 0; i<dx.length; i++) {
					nx = c[0] + dx[i];
					ny = c[1] + dy[i];
					
					if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
					if(vis[nx][ny] != -1) continue;
					
					q.offer(new int[] {nx, ny});
					vis[nx][ny] = vis[c[0]][c[1]] + 1;
					
				}
			}	
		}
	}
}
