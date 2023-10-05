import java.io.*;
import java.util.*;

public class Main {
	
	static int zeroCnt = 0;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		
		for(int i = 0; i<9; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j<9; j++) {
				board[i][j] = tmp[j] - '0';
				
				if(board[i][j]==0) {
					zeroCnt++;
				}
			}
		}
		dfs(0, zeroCnt);
	}
	
	static boolean isPossible(int idx, int num) {
		int cr = idx/9;
		int cl = idx%9;
		
		//같은 행 확인
		for(int i = 0; i<9; i++) {
			if(board[cr][i] == num) { //i 가 같은 행에 존재하는 경우
				return false; //안됨
			}
		}
		
		//같은 열 확인
		for(int i = 0; i<9; i++) {
			if(board[i][cl] == num) {
				return false;
			}
		}
		
		//3x3 확인
		int sx;
		int sy;
		
		if(cr<3) {
			sx = 0;
		}else if(cr<6) {
			sx = 3;
		}else {
			sx = 6;
		}
		
		if(cl<3) {
			sy = 0;
		}else if(cl<6) {
			sy = 3;
		}else {
			sy = 6;
		}
		
		for(int i = sx; i<sx+3; i++) {
			for(int j = sy; j<sy+3; j++) {
				if(board[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void dfs(int idx, int zero) {
		if(zero == 0) {
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(board[idx/9][idx%9] != 0) { //숫자 있으면
			dfs(idx+1, zero);
		} else {
			for(int i = 1; i<= 9 ; i++) {
				if(!isPossible(idx,i)) {
					continue;
				} else {
					board[idx/9][idx%9] = i;
					dfs(idx+1, zero-1);
					board[idx/9][idx%9] = 0; //원상복구 ..
				}
			}
		}
	}
}
