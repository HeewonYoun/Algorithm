import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] vis = new boolean[100001];
		int [] sec = new int[100001];
		
		int[] d = { 1, -1, 2 };

		q.offer(N);
		vis[N] = true;
		sec[N] = 0;

		while (!q.isEmpty()) {
			int x = q.poll();

			if (x == K) {
				System.out.println(sec[x]);
				break;
			}
				
			int nx;
			for (int i = 0; i < 3; i++) {
				nx = x + d[i];
				if (d[i] == 2) nx = x * d[i];
				
				if ( nx < 0 || nx > 100000) continue;
				if (vis[nx]) continue;
				
				q.offer(nx);
				vis[nx] = true;
				sec[nx] = sec[x] +1;

			}
		}
	}
}
