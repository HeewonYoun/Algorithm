import java.io.*;
import java.util.*;

public class Main { // ABCDE

	static ArrayList<Integer>[] list;
	static int N, M;
	static int result = 0;
	static boolean[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 사람
		M = Integer.parseInt(st.nextToken()); // 관계
		
		list = new ArrayList[N];
		vis = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(list[i]);
//		}

		// 0-1, 1-2, 2-3, 3-4
		for(int i = 0; i<N; i++) {
			if(result == 0) {
				dfs(i, 0);
			}
		}
	
		System.out.println(result);
	}

	//4개선으로 이어지면
	static void dfs(int start, int dep) {
		//System.out.println(start+" "+dep);
		if (dep == 4) {
			result = 1;
			return;
		}
		vis[start] = true;
		for(int i = 0; i<list[start].size(); i++) {
			int tmp = list[start].get(i);
			if(vis[tmp]) continue;
			
			dfs(tmp, dep+1);

		}
		vis[start] = false;
	}
}