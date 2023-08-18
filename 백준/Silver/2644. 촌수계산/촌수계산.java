import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 전체 사람의 수
		int[] t = new int[2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		t[0] = Integer.parseInt(st.nextToken()); // 촌수계산해야하는
		t[1] = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine()); // 관계 개수
		ArrayList<Integer>[] list = new ArrayList[n + 1]; // 정점의 개수만큼 - 초기값null

		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList();
		}

		int t1, t2;
		for (int i = 1; i < m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			t1 = Integer.parseInt(st.nextToken());
			t2 = Integer.parseInt(st.nextToken());

			list[t1].add(t2);
			list[t2].add(t1);
		}

		////////////////////////

		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] vis = new boolean[n + 1];
		int[] c = new int[n + 1];

		q.offer(t[0]);
		vis[t[0]] = true;
		c[t[0]] = 0;

		int tmp;
		while (!q.isEmpty()) {
			tmp = q.poll();

			if (tmp == t[1]) {
				System.out.println(c[tmp]);
				return;
			}
			
			
			for (int i = 0; i < list[tmp].size(); i++) {
				int tt = list[tmp].get(i);
				if (vis[tt])
					continue;

				q.offer(tt);
				vis[tt] = true;
				c[tt] = c[tmp] + 1;

			}
		}
		System.out.println(-1);//관계 없을 때
	}
}
