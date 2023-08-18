import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = tmp[j] - '0';
			}
		}
		
		divide(0,0,N);
		//왼쪽 위 일때 괄호 열고 .. 오른쪽 아래일때 괄호닫기
		bw.flush();
	}
	
	static void divide(int sr, int sc, int size) throws IOException {
		
		int sum = 0;
		for(int i = sr; i<sr+size; i++) {
			for(int j = sc; j<sc+size; j++) {
				sum += board[i][j];
			}
		}
		
		if(sum == size*size) {
			bw.write("1");
		}else if(sum ==0) {
			bw.write("0");
			
		}else {
			int tmp = size/2;
			bw.write("(");
			divide(sr, sc, tmp);
			divide(sr, sc+tmp, tmp);
			divide(sr+tmp, sc, tmp);
			divide(sr+tmp, sc+tmp, tmp);
			bw.write(")");
		}
	}
	

}
