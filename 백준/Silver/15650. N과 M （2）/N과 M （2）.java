import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int [] num, list;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //n까지
		M = sc.nextInt(); //중복없이 m개
		
		num = new int[M];
		list = new int[N+1];
		for(int i = 1 ; i < N+1 ; i++) {
			list[i] = i;
		}
		
		p(0,1);
	}
	
	static void p(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i<M;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i <N+1 ; i++) {
			num[cnt] = i;
			p(cnt+1,i+1);
		}
	}
}