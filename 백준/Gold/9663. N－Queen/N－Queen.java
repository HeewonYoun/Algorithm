import java.util.Scanner;

public class Main {
	
	static int cnt, N;
	static int [] b;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		b = new int[N];
		
		set(0);
		System.out.println(cnt);
	}
	
	static void set(int row) {
		if(!isAvailable(row-1)) return;
		if(row == N) {
			cnt++;
			return;
		}
		
		for(int i = 0; i<N; i++) {
			b[row] = i;
			set(row+1);
		}
	}
	
	static boolean isAvailable(int row) {
		for(int i = 0; i<row; i++) {
			//같은 행, 대각선 위치에 있을 때
			if(b[i] == b[row] || row-i == Math.abs(b[i]-b[row])) {
				return false;
			}
		}		
		return true;
	}

}
