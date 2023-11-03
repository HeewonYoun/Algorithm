import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int K;
	static int minSec;
	static int[] vis;
	static int[] dx = { -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		vis = new int[100001];
		Arrays.fill(vis, -1);

		N = Integer.parseInt(st.nextToken()); // 수빈 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		// 걸으면 1초 후에 x-1 또는 x+1
		// 순간이동 -> 0초후에 2*x의 위치로 이동

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		pq.add(new int[] { N, 0 }); // 위치, 가중치(0초 , 1초)

		while (!pq.isEmpty()) {

			int[] c = pq.poll();
			int cur = c[0];
			int time = c[1];
			// 우선순위 따라 큐에서 위치 바뀌니까 꺼낼 때 방문처리 하기
			vis[cur] = time;

//			System.out.println(cur + " " + time);

			if (cur == K) {
				break;
			}

			// 점프하는 경우
			int jump = cur * 2;
			if (jump >= 0 && jump < 100001 && vis[jump] == -1) {
				pq.offer(new int[] { jump, time });
			}

			// 걷는 경우
			for (int i = 0; i < 2; i++) {
				int walk = cur + dx[i];
				if (walk >= 0 && walk < 100001 && vis[walk] == -1) { // 범위 안에 들고 방문 안한 경우
					pq.offer(new int[] { walk, time + 1 });
				}

			}
		}

		System.out.println(vis[K]);

	}

}
