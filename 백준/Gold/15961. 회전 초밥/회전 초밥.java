import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수 (30까지 있다..)
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

		int[] list = new int[3003001];
		int[] sel = new int[3001];

		for (int i = 0; i < N; i++) { // 초밥 종류 정수 N개
			list[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < k; i++) {
			list[N+i] = list[i];
		}
		
		int sum = 0;
		
		for(int i = 0; i<k; i++) {
			if(sel[list[i]] == 0) sum++; //선택 된 적 없는 원소일 경우 sum+1
			sel[list[i]] += 1; //sel에 선택했다고 추가
		}
		
		int max = sum;
		if(sel[c] == 0) { //쿠폰번호 접시 선택안한경우
			max++; //가짓수에 하나 추가
		}
		
		int start = 0;
		int end = k-1; 
		
		while(start != N) {
			if(sel[list[start]] == 1) sum--; //빼려는 초밥을 딱 한개 먹었으면 가짓수에서 -1
			
			sel[list[start]]--; //빼려는 초밥 인덱스의 sel -1
			
			start++; // 다음 초밥부터
			end++;
			
			if(sel[list[end]] == 0) sum++;
			sel[list[end]] += 1;
			
			if(sum >= max) { //최대 초밥 가짓수
				max = sum;
				if(sel[c] == 0) {
					max++;
				}
			}
		}
		System.out.println(max);
	}

}
