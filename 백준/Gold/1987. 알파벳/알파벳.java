import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[] check = new boolean[26];
	static int max = Integer.MIN_VALUE;
	static char[][] board;
	static int r,c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];

		for (int i = 0; i < r; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				board[i][j] = tmp[j];
			}
		}
		//ABCDE FGHIJ KLMNO PQRST UVWXY Z

		// 1행 1열 - 말
		dfs(0, 0, 1);
		
		System.out.println(max);
	}

	static void dfs(int x, int y, int cnt) {
		// 같은 알파벳 적힌 칸 이면 return
		if (check[board[x][y] - 65]) {
			if (cnt-1 > max) {
				max = cnt-1;
			}
			return;
		}

		int nx, ny;
		check[board[x][y] - 65] = true;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx < 0 || nx >= r || ny < 0 || ny >=c) continue;

			dfs(nx, ny, cnt+1);

		}
		check[board[x][y] - 65] = false;
	}
}
