import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i<n+1;i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
		
	}
}
