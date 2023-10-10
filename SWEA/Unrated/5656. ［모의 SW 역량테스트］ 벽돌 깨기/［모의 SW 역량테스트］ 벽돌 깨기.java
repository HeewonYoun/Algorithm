import java.io.*;
import java.util.*;


public class Solution {
	
	static class Point{
		int r, c, cnt; //벽돌의 위치, 크기

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, W, H;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //구슬 던지는 횟수
			W = Integer.parseInt(st.nextToken()); //가로
			H = Integer.parseInt(st.nextToken()); //세로
			
			int[][]map = new int[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j< W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			drop(0, map);
			System.out.println("#"+tc+" "+min);
			
		}

	}
	
	static boolean drop(int cnt, int[][] map) {
		
		//남은 벽돌 개수 체크
		int result = 0;
		for(int r = 0; r<H; r++) {
			for(int c = 0; c<W; c++) {
				if(map[r][c] != 0) result++;
			}
		}
		
		//남은 벽돌이 0개라면
		if(result == 0) {
			min = 0;
			return true;
		} 
		
		if(cnt == N) { //구슬 다 던졌다면
			if(min > result) {
				min = result;
			}
			return false;
		}
		
		int[][] newMap = new int[H][W]; // 복사할 배열
		
		for(int c = 0; c<W; c++) { //깨트릴 맨 위에 있는 벽돌 정하기
			int r = 0;
			
			while(r < H && map[r][c] == 0) {//빈칸인경우
				r++;//다음 행으로
			}
			
			if(r == H) continue; // 해당 열이 다 빈칸인 경우 다음 열로
			
			//깨트릴 벽돌이 존재하는 경우
			copyA(map, newMap); //배열 복사
			breakB(newMap, r, c); // 벽돌 깨기
			down(newMap); //벽돌 내리기
			if(drop(cnt+1, newMap)) return true;
		}
		return false;
	}
	
	//벽돌 깨기
	static void breakB(int[][] map, int r, int c) {
		Queue<Point> q = new ArrayDeque<Point>();
		
		////////////////////////////////////////////
		if(map[r][c] > 1) q.offer(new Point(r, c, map[r][c])); //현재 벽돌이 있으면 큐에 넣기, 1이면 자신만 없어지니까 큐에 안넣음
		map[r][c] = 0; // 걍 한번치면 깨짐
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i = 0; i<4; i++) { //4방향으로
				int cr = cur.r;
				int cc = cur.c;
				
				for(int j = 0; j<cur.cnt-1; j++) { //벽돌에 적힌 숫자만큼 주위 벽돌 제거
					cr = cr + dr[i]; // 누적해서 이동시켜줘야함
					cc = cc + dc[i];
					
					if(cr < 0 || cc < 0 || cr >= H || cc >= W || map[cr][cc] == 0) continue; //범위 벗어나면
					if(map[cr][cc] > 1) q.offer(new Point(cr, cc, map[cr][cc]));
					map[cr][cc] = 0;
					
				}
			}
		}
	}
	
	//밑으로 내리기
	static void down(int[][] map) {
		
		for(int c = 0; c < W; c++) {
			int r = H-1; //여기로 내림
			int nr = -1; //교환할 비어있는 벽돌의 행
			
			while(r > 0) {

				if(map[r][c] == 0) {
					
					nr = r - 1;
					
					while(nr > 0 && map[nr][c] == 0) {
						nr--;
					}
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				//////////다 내렸을 경우
				if(nr == 0) {
					break;
				}else r--;
			}

		}
	}	
	
	//배열 복사
	static void copyA(int[][] map, int[][] newMap) {
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}