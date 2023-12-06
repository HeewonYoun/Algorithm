import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] memoZero = new int[41];
		int[] memoOne = new int[41];
		
		memoZero[0] = 1;
		memoZero[1] = 0;
		memoZero[2] = 1;
		
		memoOne[0] = 0;
		memoOne[1] = 1;
		memoOne[2] = 1;
		
		for(int tc = 0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 3; i<N+1; i++) {
				memoOne[i] = memoOne[i-1] + memoOne[i-2];
				memoZero[i] = memoZero[i-1] + memoZero[i-2];
			}
			
			System.out.println(memoZero[N]+" "+memoOne[N]);
		}
	}
}