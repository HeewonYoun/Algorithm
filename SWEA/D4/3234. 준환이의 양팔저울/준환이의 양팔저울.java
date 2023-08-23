import java.io.*;
import java.util.*;

public class Solution {

	static int[] w;
	static int N;

	static int anw;
	static boolean vis[];

	static int[] res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			anw = 0;
			N = Integer.parseInt(br.readLine());

			w = new int[N];
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				w[i] = Integer.parseInt(st.nextToken());
				sum += w[i];
			}

			res = new int[N];
			vis = new boolean[N];


			dfs(0, 0, 0,sum);
			System.out.println("#" + t + " " + anw);
		}

	}
    
	// left 순서.. 전체 무게
	static void dfs(int cnt, int lsum, int rsum, int remain) {
		if (rsum > lsum) {
			return;
		}
		if (lsum >= rsum + remain) {
			int sum = 1;
			for (int i = 0; i < N - cnt; i++)
				sum *= 2;
			for (int i = 1; i <= N - cnt; i++)
				sum *= i;
			anw += sum;

			return;
		}

		if (cnt == N) {
			anw++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (vis[i] == true)
				continue;

			vis[i] = true;
			dfs(cnt + 1, lsum, rsum + w[i], remain-w[i]);
			dfs(cnt + 1, lsum + w[i], rsum,remain-w[i]);
			vis[i] = false;
		}
	}
}
