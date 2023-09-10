import java.io.*;
import java.util.*;

public class Main {
	static int F, S, G, U, D;
	static int[] dy = new int[2];
	static int[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken()); // 총 F층 건물
		S = Integer.parseInt(st.nextToken()); // 강호가 지금 있는 곳
		G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 곳의 위치
		U = Integer.parseInt(st.nextToken()); // U층을 가는 버튼
		D = Integer.parseInt(st.nextToken()); // 아래로 D층 가는 버튼
		
		dy[0] = U;
		dy[1] = -D;
		
		vis = new int[F+1]; //1층부터 시작
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(S);
		vis[S] = 0; //시작
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == G) break;
			
			for(int i = 0; i<2; i++) {
				if(dy[i] == 0) continue; //위로 올라가는거, 내려가는게 0일경우 고려X
				int ny = cur + dy[i];
				if(ny > F || ny < 1) continue;
				if(vis[ny] != 0) continue;
				
				q.offer(ny);
				vis[ny] = vis[cur]+1;
			}
		}
		
		if(S==G){
			System.out.println(0);
		}
		else if(vis[G] != 0) {
			System.out.println(vis[G]);
		}else {
			System.out.println("use the stairs");
		}
	}
}
