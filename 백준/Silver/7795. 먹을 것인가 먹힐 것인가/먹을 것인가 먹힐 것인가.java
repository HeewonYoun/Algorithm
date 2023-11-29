import java.io.*;
import java.util.*;

public class Main{

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
			
			//이진탐색 방법
			Arrays.sort(B); //B 오름차순 정렬
			int cnt = 0;
			
			for(int i = 0; i<N; i++) {
				int start = 0;
				int end = M-1;
				
				while(start <= end) { //탐색 구간 길이가 1 이상
					int mid = (start+end)/2;
					if(B[mid] < A[i]) {
						start = mid + 1;
					}else {
						end = mid - 1;
					}
				}
				cnt += start;
			}
			System.out.println(cnt);
		}
	}
}