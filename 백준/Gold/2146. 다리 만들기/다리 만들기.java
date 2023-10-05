import java.io.*;
import java.util.*;

public class Main {
	
	static int [] dx = {-1, 1, 0, 0}; //상하좌우
	static int [] dy = {0, 0, -1, 1};
	static int min = Integer.MAX_VALUE;
	static int [][] board;
	static int N;
	static int [][] board2;
	static int icnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		board = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 구분
		board2 = new int[N][N]; 
		icnt = 0; //섬 개수
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(board[i][j] == 1 && board2[i][j] == 0) {
					icnt++;
					q.offer(new int[] {i,j});
					board2[i][j] = icnt;
				}
				
				while(!q.isEmpty()) {
					int cur[] = q.poll();
					
					for(int k = 0; k<4; k++) {
						int nx = cur[0] + dx[k];
						int ny = cur[1] + dy[k];
						
						if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						if(board[nx][ny] != 1) continue; //섬이 아닌경우
						if(board2[nx][ny] != 0) continue; 
						
						q.offer(new int[] {nx, ny});
						board2[nx][ny] = icnt;
					}
				}
			}
		}
		
		int[][] bridge = new int[N][N];
		//다리놓기
		for(int i = 1; i<=icnt; i++) { // 섬 개수만큼 반복
			
			for(int ii = 0; ii<N; ii++) {
				for(int jj = 0; jj<N; jj++) {
					bridge[ii][jj] = 0;
				}
			}
			
			Queue<int[]> bq = new ArrayDeque<int[]>();
			
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					if(board2[r][c] == 0) {
						//상하좌우에 시작 섬이 있는 경우 1로 시작하도록
						for(int k = 0; k<4; k++) {
							int nx = r + dx[k];
							int ny = c + dy[k];
							
							if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; //범위 벗어나는경우
							if(board2[nx][ny] != i) continue;
							
							bq.offer(new int[] {r,c});
							bridge[r][c] = 1;
						}
					}
				}
			}
			
			while(!bq.isEmpty()) {
				int cur[] = bq.poll();
				
				if(bridge[cur[0]][cur[1]] >= min) break;
				
				for(int k = 0; k<4; k++) {
					int nx = cur[0] + dx[k];
					int ny = cur[1] + dy[k];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; //범위 벗어나는경우
					if(board2[nx][ny] != 0) { 
						if(board2[nx][ny] != i) { //짧은 다리 구하기
							if(bridge[cur[0]][cur[1]]< min) {
								min = bridge[cur[0]][cur[1]];
							}
						}
						continue; //바다가 아닌 경우
					}
					if(bridge[nx][ny] != 0) continue; //방문한 곳 다시 방문한 경우
					
					
					bq.offer(new int[] {nx, ny});
					bridge[nx][ny] = bridge[cur[0]][cur[1]] + 1;
				}
			}
			
//			for(int j = 0; j<N; j++) {
//			System.out.println(Arrays.toString(bridge[j]));
//		}
//			System.out.println();
			
		}
		System.out.println(min);
	}
}
