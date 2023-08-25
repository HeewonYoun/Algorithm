import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수

		ArrayList<int[]>[] list = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int start = Integer.parseInt(br.readLine());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new int[] { to, weight });
		}

		boolean[] vis = new boolean[V + 1];
		int[] distance = new int[V + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		distance[start] = 0;
		pq.offer(new int[] {start,distance[start]});

		int [] cur;
		int min = 0, stopOver = 1;
		while (!pq.isEmpty()) {
			cur = pq.poll();
			stopOver = cur[0];
			min = cur[1];

			// 방문처리
			vis[stopOver] = true;

			for (int i = 0; i < list[stopOver].size(); i++) {
				int[] tmp = list[stopOver].get(i);
				
				if(!vis[tmp[0]] && distance[tmp[0]] > tmp[1] + min) {
					distance[tmp[0]] = tmp[1] + min;
					pq.offer(new int[] {tmp[0], distance[tmp[0]]});
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
			if(distance[i] != Integer.MAX_VALUE) {
				System.out.println(distance[i]);
			}else {
				System.out.println("INF");
			}
		}
	}
}
