import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		int[] inDegree = new int[N + 1]; // 진입차수 관리 배열
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			inDegree[b]++;

		}

		for (int i = 1; i < N + 1; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		if(q.size() == 0) return;
		
		int tmp;
		while (!q.isEmpty()) {
			tmp = q.poll();
			result.add(tmp);
			
			//연결된 정점들의 진입차수 -1
			for(int n : list[tmp]) {
				inDegree[n]--;
				if(inDegree[n] == 0) {
					q.offer(n);
				}
			}
		}
		
		for(int i = 0; i<result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}

	}

}