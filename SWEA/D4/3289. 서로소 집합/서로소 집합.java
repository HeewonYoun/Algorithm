import java.io.*;
import java.util.*;


public class Solution {
	
	static int[] parents;
	
	static void makeSet(int a) {
		for(int i = 1; i<a+1; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a == b) return;
		
		parents[b] = a;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			makeSet(n);
			
			System.out.print("#"+t+" ");
			int tmp, a, b;
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				tmp = Integer.parseInt(st.nextToken());
				
				if(tmp == 0) {
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					union(a,b);
					continue;
				}
				
				if(tmp == 1) {
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					
					int t1 = findSet(a);
					int t2 = findSet(b);
					if(t1 == t2) {
						System.out.print(1);
					}else {
						System.out.print(0);
					}
				}
			}
			System.out.println();
		}
	}
}
