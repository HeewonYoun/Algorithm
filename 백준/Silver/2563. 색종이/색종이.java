import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 색종이 수
		int size = 0; // 색종이 붙은 검은 영역의 넓이
		int[][] board = new int[101][101];
		int sx, sy;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());

			for (int j = sx; j < sx + 10; j++) {
				for (int k = sy; k < sy + 10; k++) {
					if(board[j][k] == 0) {
						board[j][k] = 1;
					}
				}
			}
		}

		for(int i = 0; i<101; i++) {
			for(int j = 0; j<101; j++) {
				if(board[i][j] == 1) {
					size++;
				}
			}
		}
		System.out.println(size);
	}

}