import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //tc 수
		
		for(int tc = 0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // A의 수
			int M = Integer.parseInt(st.nextToken()); // B의 수
			
			Integer[] A = new Integer[N];
			Integer[] B = new Integer[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) { //A 크기 입력
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) { //B 크기 입력
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			//입력완료
			//A, B 내림차순으로 정렬하기
			Arrays.sort(A,Collections.reverseOrder());
			Arrays.sort(B,Collections.reverseOrder());

			int cnt = 0; // 쌍의 개수
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(A[i] > B[j]) {
						cnt += M-j;
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
