import java.io.*;
import java.util.*;

public class Main {
	
	static int[] map;
	static int n;
	static boolean[] vis, done; //방문, 팀 완성 여부
	static int cnt; //팀에 속한 학생 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine()); // 학생의 수
			map = new int[n + 1]; // index 1부터 사용하려고
			vis = new boolean[n+1];
			done = new boolean[n+1];
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n + 1; i++) {
				map[i] = Integer.parseInt(st.nextToken());
				
				if(map[i] == i) { //자기 자신과 팀 하는 경우
					done[i] = true; //팀 완성 여부 true
					cnt++;
				}
			}
			for(int i = 1; i<n+1; i++) {
				if(!done[i]) dfs(i);
			}
			
			System.out.println(n-cnt);
		}
	}
	
	static void dfs(int idx) {
		
		if(vis[idx]) { //이미 방문한 경우
			done[idx] = true; //팀 편성 완료
			cnt++;
		} else {
			vis[idx] = true; //방문 안했을 때 방문 처리
		}
		
		if(!done[map[idx]]) {
			dfs(map[idx]);
		}
		
		vis[idx] = false;
		done[idx] = true;
	}
}