import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static int[][] dx = {{0,0,1}, {0,1,1}, {0,1,1}}; // 가로, 세로, 대각선 순서
	static int[][] dy = {{1,0,1}, {0,0,1}, {1,0,1}};
	static int[] dir = {0, 1, 2}; //0:가로 1:세로 2:대각선
	static long[][][] viscnt;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		viscnt = new long[3][N+1][N+1];
	
		for(int i = 1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		viscnt[0][1][2] = 1;
		
		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				if((i == 1 && j == 1) || (i == 1 && j == 2)) continue;
				
				if(map[i][j] == 1) continue;
				
				if(viscnt[0][i][j] == 0) { //가로 - 왼쪽 대각선 위, 왼쪽 더하기
					viscnt[0][i][j] = viscnt[0][i][j-1] + viscnt[2][i][j-1];
				}
				
				if(viscnt[1][i][j] == 0) { //세로 - 왼쪽대각선위, 위 더하기
					viscnt[1][i][j] = viscnt[1][i-1][j] + viscnt[2][i-1][j];
				}
				
				if(viscnt[2][i][j] == 0) { //대각선 - 세개
					if(map[i][j-1] != 1 && map[i-1][j] != 1) { // 세곳 1 아닌경우 빼기
						viscnt[2][i][j] = viscnt[0][i-1][j-1] + viscnt[1][i-1][j-1] + viscnt[2][i-1][j-1];
					}
					
				}
				
			}
		}
		
		long sum = 0;
		sum = viscnt[0][N][N] + viscnt[1][N][N] + viscnt[2][N][N] ;
		System.out.println(sum);
	}
	
 
}