import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //설탕 무게
		int cnt = 0;
		
		while(N>0) {
			if(N%5 == 0) { //5로 나누어 떨어지면
				cnt += N/5;
				System.out.println(cnt);
				return;
			}
			if(N<3) { //무게가 3보다 작으면
				System.out.println(-1);
				return;
			}
			N = N-3;
			cnt++;
		}
		System.out.println(cnt);
	}
}
