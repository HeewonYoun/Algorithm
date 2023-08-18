import java.util.*;
import java.io.*;

public class Main { // 회의실 배정1

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] h = new int[N][2];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h[i][0] = Integer.parseInt(st.nextToken());
			h[i][1] = Integer.parseInt(st.nextToken());
		}

		// 회의 종료 시간이 빠른 순으로 정렬
		Arrays.sort(h, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]== o2[1]) { //종료 시간이 같은경우 시작 시간이 느린거부터
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
		});
		
		int i = 0;
		cnt++; // 첫번째 경우 카운트
		for (int j = 1; j < N; j++) {
			if (h[i][1] <= h[j][0]) {
//				System.out.println(j);
				i = j;
				cnt++;
			}	
		}

		// 최대 사용할 수 있는 회의의 최대 개수 출력
		System.out.println(cnt);
	}

}
