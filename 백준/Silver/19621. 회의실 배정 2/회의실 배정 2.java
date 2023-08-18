import java.util.*;
import java.io.*;

public class Main { // 회의실배정2

	static int max, N, count;
	static int[][] h;
	static int[][] s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		h = new int[N][3];
		s = new int[N][3];
		max = 0;
		count = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h[i][0] = Integer.parseInt(st.nextToken()); // 회의 시작시간
			h[i][1] = Integer.parseInt(st.nextToken()); // 회의 끝나는 시간
			h[i][2] = Integer.parseInt(st.nextToken()); // 회의 인원

			if (max < h[i][0]) {
				max = h[i][0];
			}
		}

		Arrays.sort(h, new Comparator<int[]>() { // 종료시간으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

	
		c(0, 0, count);

		System.out.println(count); // 회의를 진행할 수 있는 최대 인원

	}

	static void c(int cnt, int start, int sum) {
		
		if (start > max) {
			if (count < sum) {
				count = sum;
			}
			return;
		}

		for (int i = cnt; i < N; i++) {
			if(h[i][0] < start) continue;
			c(i + 1, h[i][1], sum + h[i][2]);
		}
	}

}
