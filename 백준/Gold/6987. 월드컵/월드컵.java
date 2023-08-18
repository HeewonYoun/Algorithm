import java.util.*;
import java.io.*;

public class Main {

	static int[][] score;
	static boolean check;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 4; t++) {
			result = 0;
			check = false;
			score = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				int sum = 0;
				for (int j = 0; j < 3; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
					sum += score[i][j];
				}

				// 한 팀 경기수 5회 아닐 때
				if (sum != 5) {
					result = 0;
					check = true;
				}
			}

			if (!check) {
				dfs(0, 0, 1);
			}

			System.out.print(result + " ");

		}

	}

	static void dfs(int cnt, int idx, int n) {
		if (check)
			return;

		if (cnt == 15) { // 총 경기수 15번이면
			check = true;
			result = 1;
			return;
		}

		if (score[idx][0] == 0 && score[idx][1] == 0 && score[idx][2] == 0) {
			dfs(cnt, idx + 1, idx + 2);
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = n; j < 6; j++) {

					if (score[idx][i] > 0 && score[j][2 - i] > 0) {

						score[idx][i]--;
						score[j][2 - i]--;

						dfs(cnt + 1, idx, j + 1);

						score[idx][i]++;
						score[j][2 - i]++;

					}
				}
			}
		}
	}
}
