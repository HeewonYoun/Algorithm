import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] liq = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liq[i] = Long.parseLong(st.nextToken());
		}
		
		// 특성값 정렬된 순서로 주어짐

		int start = 0;
		int end = N - 1;

		long result = Integer.MAX_VALUE;
		long num1 = 0;
		long num2 = 0;

		while (start < end) {
			long sum = liq[end] + liq[start];

			int mid = (start + end) / 2;

			if (Math.abs(sum) < result) {
				result = Math.abs(sum);
				num1 = liq[start];
				num2 = liq[end];

			}
			if (sum > 0) {

				end--;

			} else {
				start++;
			}
		}
		System.out.println(num1 + " " + num2);
	}
}