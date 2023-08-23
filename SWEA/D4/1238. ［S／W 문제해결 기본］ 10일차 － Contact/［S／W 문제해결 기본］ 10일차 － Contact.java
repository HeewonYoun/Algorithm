import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc < 11; tc++) {

			ArrayList<Integer>[] list = new ArrayList[101];
			for (int i = 0; i < 101; i++) {
				list[i] = new ArrayList<>();
			}

			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());

			int dc = Integer.parseInt(st.nextToken()); // 입력받는 데이터 길이
			int start = Integer.parseInt(st.nextToken()); // 시작점

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < dc / 2; i++) {
				int f = Integer.parseInt(st.nextToken()); // from
				int t = Integer.parseInt(st.nextToken()); // to

				if (list[f].contains(t))
					continue; // 동일한 (from,to)쌍이 여러번 반복되는 경우 제외
				list[f].add(t);
			}

			Queue<Integer> q = new ArrayDeque<Integer>();
			int[] vis = new int[101]; //레벨별로 관리하기 위해서 int 배열로
			q.offer(start);
			vis[start] = 1;

			while (!q.isEmpty()) {
				int n = q.poll();

				for (int j = 0; j < list[n].size(); j++) {
					int tmp = list[n].get(j);
					if (vis[tmp] != 0) continue;

					q.offer(tmp);
					vis[tmp] = vis[n]+1;
				}
			}
			
			int max = 0;
			int idx = 0;
			for(int i = 0; i<101; i++) {
				if(vis[i] >= max) {
					max = vis[i];
					if(idx < i) {
						idx = i;
					}
				}
			}
			System.out.println("#" + tc + " " + idx);
		}
	}
}