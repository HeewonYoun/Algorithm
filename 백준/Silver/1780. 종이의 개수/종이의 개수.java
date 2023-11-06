import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static int zero, one, mone;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, N);
		System.out.println(mone);
		System.out.println(zero);
		System.out.println(one);
		
	}
	
	public static void cut(int sr, int sc, int size) {
		int[] cnt = new int[3];
		
		for(int i = sr; i < sr+size; i++) {
			for(int j = sc; j<sc+size; j++) {
				if(map[i][j] == 0) cnt[0] = 1;
				else if(map[i][j] == 1) cnt[1] = 1;
				else if(map[i][j] == -1)cnt[2] = 1;
			}
		}
		
		if(cnt[0]+cnt[1]+cnt[2] == 1) { //기저조건
			if(cnt[0] == 1) zero ++;
			else if(cnt[1] == 1) one++;
			else mone++;
		}else { //다른 수로 되어있는 경우
			int divide = size/3;
			
			cut(sr, sc, divide); 
			cut(sr, sc+divide, divide); 
			cut(sr, sc+(divide*2), divide); 
			
			cut(sr+divide, sc, divide); 
			cut(sr+divide, sc+divide, divide); 
			cut(sr+divide, sc+(divide*2), divide);
			
			cut(sr+(divide*2), sc, divide); 
			cut(sr+(divide*2), sc+divide, divide); 
			cut(sr+(divide*2), sc+(divide*2), divide);
		}
	}
}
