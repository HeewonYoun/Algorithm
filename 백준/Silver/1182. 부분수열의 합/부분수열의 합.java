import java.io.*;
import java.util.*;

public class Main {

	static int N, S;
	static int[] num;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		num = new int[N];
		cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		if (S == 0) { // 공집합일때 ,,
			System.out.println(cnt - 1);
		} else {
			System.out.println(cnt);
		}
	}

	static void dfs(int size, int sum) {
		if (size == N) {
			if (sum == S) cnt++;
			return;
		}
		dfs(size + 1, sum + num[size]);
		dfs(size + 1, sum);
	}
}
