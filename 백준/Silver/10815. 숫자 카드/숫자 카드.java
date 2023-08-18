import java.util.*;
import java.io.*;

public class Main {

	static int[] arr, cmp;
	static int[] res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr); // 오름차순 정렬

		int M = Integer.parseInt(br.readLine());
		res = new int[M];
		cmp = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			cmp[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			binarySearch(N, i);
		}
		
		for(int i = 0; i<M; i++) {
			System.out.print(res[i]+" ");
		}
	}

	static void binarySearch(int size, int key) {
		int start = 0;
		int end = size - 1;

		while (start <= end) { //탐색 구간 길이가 1 이상일때
			int mid = (start + end) / 2;
//			System.out.println(mid);

			if (cmp[key] == arr[mid]) {
				res[key] += 1;
				break;
			}
			if (cmp[key] > arr[mid]) {
				start = mid + 1;
			}
			if (cmp[key] < arr[mid]) {
				end = mid - 1;
			}
		}
	}

}
