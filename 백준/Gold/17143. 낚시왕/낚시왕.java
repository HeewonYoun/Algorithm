import java.io.*;
import java.util.*;

public class Main {

	static class Shark {
		int r;
		int c;
		int s; // 상어 속력
		int d; // 상어 이동방향
		int z; // 상어 크기

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열
		int M = Integer.parseInt(st.nextToken()); // 상어의 수

		Shark[][] board = new Shark[R][C];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 상어 속력
			int d = Integer.parseInt(st.nextToken()); // 상어 이동방향
			int z = Integer.parseInt(st.nextToken()); // 상어 크기

			board[r - 1][c - 1] = new Shark(r - 1, c - 1, s, d-1, z);
		}

		int sum = 0;
		int[][] d = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }; // 상하좌우

		for (int i = 0; i < C; i++) {

			for (int j = 0; j < R; j++) { // 낚시왕 한칸 이동, 상어잡기
				if (board[j][i] != null) {
//					System.out.println(board[j][i].z);
					sum += board[j][i].z;
					board[j][i] = null; // 빈칸으로 초기화
					break;
				}
			}

			// 상어이동
			Shark [][] tmp = new Shark[R][C];
			
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					if (board[j][k] == null) continue; // 상어 존재 안하면

					Shark shark = board[j][k];
					int move;
					if (shark.d == 0 || shark.d == 1) move = shark.s % ((R - 1) * 2); // 상하
					else move = shark.s % ((C - 1) * 2); // 좌우

					for (int s = 0; s < move; s++) {
						int nr = shark.r + d[shark.d][0];
						int nc = shark.c + d[shark.d][1];

						if (nr < 0 || nc < 0 || nr >= R || nc >= C) { //범위 넘을 경우 방향 바꾸기
							if (shark.d == 0) shark.d = 1; // 방향 바꾸기
							else if (shark.d == 1) shark.d = 0;
							else if (shark.d == 2) shark.d = 3;
							else if (shark.d == 3) shark.d = 2;

							shark.r += d[shark.d][0];
							shark.c += d[shark.d][1];
							continue;
						}
						shark.r = nr;
						shark.c = nc;
					}
					
					if (tmp[shark.r][shark.c] != null && tmp[shark.r][shark.c].z > shark.z) { //원래 있던 상어가 더 크면
						continue;
					}
					tmp[shark.r][shark.c] = shark;
				}
			}
			board = tmp; // 다 이동 하고 보드 바꾸는거
		}
		System.out.println(sum);
	}

}
