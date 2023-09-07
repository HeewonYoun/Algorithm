import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j<N; j++) {
				board[i][j] = tmp[j]-'0';
			}
		}
		
		//단지수, 집크기 오름차순
		int[] dx = {-1, 1, 0, 0}; //상하좌우
		int[] dy = {0, 0, -1, 1};
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] vis = new boolean[N][N];
		int cnt = 0;
		int size = 0;
		ArrayList<Integer> hsize = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(vis[i][j])continue;
				if(board[i][j]==0)continue;
				
				size = 1;
				q.offer(new int[] {i,j});
				vis[i][j] = true;
				cnt++;
				
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					
					for(int k = 0; k<4; k++) {
						int nx = cur[0] + dx[k];
						int ny = cur[1] + dy[k];
						
						if(nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
						if(vis[nx][ny] || board[nx][ny] == 0) continue;
						
						q.offer(new int[] {nx, ny});
						vis[nx][ny] = true;
						size++;
					}
				}
				hsize.add(size);
			}
		}
		System.out.println(cnt);
		Collections.sort(hsize);
		for(int i = 0; i<cnt; i++) {
			System.out.println(hsize.get(i));
		}
	}
}
