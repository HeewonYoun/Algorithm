import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};//상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int max = 1;
	static int[][] board;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		List<Integer> raincase = new ArrayList<>();
		
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(!raincase.contains(board[i][j])) {
					raincase.add(board[i][j]);
				}
			}
		}
		
		for(int i = 0; i<raincase.size(); i++) {
			bfs(raincase.get(i));
		}
		//장마철에 물에 잠기지 않는 안전한 영역의 최대 개수 출력
		System.out.println(max);
	}
	
	
	static void bfs(int g) {
		boolean[][] vis = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<int[]>();
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(vis[i][j]) continue;
				if(board[i][j] > g) {
					q.offer(new int[] {i, j});
					vis[i][j] = true;
					cnt++;
				}
				
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					
					for(int k = 0; k<4; k++) {
						int nx = cur[0] + dx[k];
						int ny = cur[1] + dy[k];
						
						if(nx<0 || ny <0 || nx >= N || ny >= N) continue;
						if(vis[nx][ny]) continue;
						if(board[nx][ny] <= g) continue;
						
						q.offer(new int[] {nx, ny});
						vis[nx][ny] = true;
					}
				}
				
				if(cnt > max) {
					max = cnt;
				}
			}
		}
	}
}
