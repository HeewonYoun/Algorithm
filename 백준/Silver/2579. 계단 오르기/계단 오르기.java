import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine().trim()); //계단의 개수 <= 300
		
		int[] d = new int[cnt+1];
		int[] score = new int[cnt+1];
		score[0] = 0; //시작점
		
		for(int i = 1; i<cnt+1; i++) {
			score[i] = Integer.parseInt(br.readLine().trim());
		}
		
		d[0] = 0;
		d[1] = score[1];
        
		if(cnt >= 2) {
			d[2] = score[1]+score[2];
		}
		
		for(int i = 3; i<cnt+1; i++) {
			d[i] = Math.max(d[i-2], d[i-3]+score[i-1])+score[i];
		}
		System.out.println(d[cnt]);
	}
}
