import java.io.*;
import java.util.*;

public class Main {

	static int V, E;
	static int[] parents;

	static void makeSet() {
		for (int i = 1; i < V + 1; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b, c;

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parents = new int[V + 1];
		makeSet();

		List<int[]> l = new ArrayList<int[]>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); // 정점
			b = Integer.parseInt(st.nextToken()); // 정점
			c = Integer.parseInt(st.nextToken()); // 가중치

			l.add(new int[] { a, b, c });
		}

		l.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		int result = 0;
		int cnt = 0;
		for (int[] tt : l) {
//				System.out.println(Arrays.toString(tt));
			if (union(tt[0], tt[1])) {
				result += tt[2];
				if (++cnt == V - 1)
					break;
			}
		}

		System.out.println(result);

	}

}
