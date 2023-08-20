import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 가로칸수
		int N = Integer.parseInt(st.nextToken()); // 세로칸수
		int H = Integer.parseInt(st.nextToken()); // 쌓아올리는 상자수

		int[][][] box = new int[H][N][M];
		int[][][] vis = new int[H][N][M];
		Queue<int[]> q = new ArrayDeque<int[]>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					
					if(box[i][j][k] == 1) {
						q.offer(new int[] {i,j,k});
						vis[i][j][k] = 1;
					}
				}
			}
		}

		int[] dx = { 0, 0, -1, 1, 0, 0 }; // 왼, 오, 앞, 뒤, 위, 아래
		int[] dy = { -1, 1, 0, 0, 0, 0 };
		int[] dz = { 0, 0, 0, 0, -1, 1 };

		int[] c;
		int nx, ny, nz;
		while(!q.isEmpty()) {
			c = q.poll();
			
			for(int i = 0; i<6; i++) {
				nz = c[0] + dz[i];
				nx = c[1] + dx[i];
				ny = c[2] + dy[i];
								
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
//				System.out.println(nx+" "+ny+" "+nz);
				if(vis[nz][nx][ny] != 0 || box[nz][nx][ny] == -1) continue;
				
				q.offer(new int[] {nz, nx, ny});
				vis[nz][nx][ny] = vis[c[0]][c[1]][c[2]] + 1;
//				System.out.println(vis[nz][nx][ny]);
				
			}
			
		}

		int result = 0;
		check: for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					
					if(vis[i][j][k] == 0 && box[i][j][k] != -1) {
						result = 0;
						break check;
					} 

					if(vis[i][j][k] > result) {
						result = vis[i][j][k];
					}
				}
			}
		}
		
		System.out.println(result-1);

	}

}
