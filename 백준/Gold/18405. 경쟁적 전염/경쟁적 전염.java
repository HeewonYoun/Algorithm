import java.io.*;
import java.util.*;

public class Main {
	
	static int [][] map;
	static int N, K;
	static int S, X, Y;
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1}; //상하좌우
	static PriorityQueue<int[]> pq;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); //바이러스 번호

		map = new int[N][N];
        
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		}); 

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0) {
					pq.offer(new int[] {i, j, map[i][j]});
				}
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); //초
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		solution();
	}
	
	static void solution() {
		int time = 1; //시간
		
		while(time < S+1) {
			
			//바이러스 증식
			bfs();
			
			//1초 후인 상태
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println(time);
			
			//큐에 넣기
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][j] != 0) {
						pq.offer(new int[] {i, j, map[i][j]});
					}
				}
			}
			if(pq.size() == N*N) break;
			time++;
		}
		System.out.println(map[X-1][Y-1]);
	}
	
	static void bfs() {
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cx = cur[0];
			int cy= cur[1];
			int num = cur[2];
			
			for(int i = 0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(map[nx][ny] != 0) continue;
				
				map[nx][ny] = num;
				
			}
		}
	}
}
