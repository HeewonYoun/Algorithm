import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		int[] d = new int[11]; //n<11
		d[0] = 0;
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			for(int i = 4; i < n+1; i++) {
				d[i] = d[i-1] + d[i-2] + d[i-3];
			}
			System.out.println(d[n]);
		}
	}
}
