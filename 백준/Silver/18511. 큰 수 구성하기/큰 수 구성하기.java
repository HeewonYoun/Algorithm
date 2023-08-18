import java.util.*;
import java.io.*;

public class Main { // 큰 수 구성하기

	static int[] list;
	static int K, N;
	static int max = 0; // K로구성된것 중 제일 큰 max <=N

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		list = new int[K];
		for (int i = 0; i < K; i++) {
			list[i] = sc.nextInt();
		}

		dfs(0);
		System.out.println(max);
	}

	static void dfs(int sum) {
		//종료조건
		if(sum > N) return;
		if(sum > max) max = sum;

		for (int i = 0; i < K; i++) { // 모든 조합 만듦
			dfs(sum*10 + list[i]);
		}
	}

}
