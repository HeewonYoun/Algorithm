import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); //행
		int N = Integer.parseInt(st.nextToken()); //열
		int K = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[M][N];
		
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			//왼쪽아래 꼭짓점 좌표
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			//오른쪽 위 꼭짓점 좌표
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			for(int j = sy; j<ey; j++) {
				for(int k = sx; k<ex; k++) {
					board[j][k] = 1;
				}
			}
		}
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		int[] dx = {-1, 1, 0, 0}; //상하좌우
		int[] dy = {0, 0, -1, 1};
		int cnt = 0; //나누어지는 영역 개수
		int area = 0;
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				if(board[i][j] == 1) continue;
				if(board[i][j] == 0) {
					q.offer(new int[] {i,j});
					board[i][j]=1;
					area = 1;
					cnt++;
				}
				
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					
					for(int k = 0; k<4; k++) {
						int nx = cur[0] + dx[k];
						int ny = cur[1] + dy[k];
						
						if(nx < 0 || nx >= M || ny < 0 || ny >= N )continue;
						if(board[nx][ny] == 1) continue;
						
						board[nx][ny] = 1;
						q.offer(new int[] {nx, ny});
						area++;
					}
				}
				result.add(area);
			}
		}
		Collections.sort(result);
		
		System.out.println(cnt);
		for(int i = 0; i<cnt; i++) {
			System.out.print(result.get(i)+" ");
		}	
	}
}
