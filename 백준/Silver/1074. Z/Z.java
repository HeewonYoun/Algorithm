import java.io.*;
import java.util.*;

public class Main {

	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		int s = (int) Math.pow(2, N);

		div(r, c, s);

		System.out.println(cnt);

	}

	static void div(int r, int c, int size) {
		
		if (size == 1) {
			return;
		}

		int half = size / 2;

		if (r < half && c < half) { // 왼쪽 위
			div(r, c, half);
		}
		if (r < half && c >= half) { // 오른쪽 위
			cnt += half * half;
			div(r, c-half, half);
		}
		if (r >= half && c < half) { // 왼쪽 아래
			cnt += (half * half) * 2;
			div(r-half, c, half);
		}
		if (r >= half && c >= half) { // 오른쪽 아래
			cnt += (half * half) * 3;
			div(r-half, c-half, half);
		}

	}

}
