import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] data;
	static int n;
	static boolean[] isSelected;
	static int cha = 999999999;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine()); // 재료의 개수
		data = new int[n][2];
		isSelected = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken()); //신맛
			data[i][1] = Integer.parseInt(st.nextToken()); //쓴맛
		}
		ps(0,0);
		System.out.println(cha);
	}

	
	static void ps(int cnt, int sc) {
		if(cnt == n) {
			int ssum = 1; //신맛 곱
			int bsum = 0; //쓴맛 합
			if(sc > 0) {
				for(int i = 0; i<n;i++) {
					if(isSelected[i]) {
						ssum *= data[i][0];
						bsum += data[i][1];
					}
					
				}
				if(Math.abs(ssum-bsum)<cha) {
					cha = Math.abs(ssum-bsum);
				}
			}
			return;
		}
		
		isSelected[cnt]=true;
		ps(cnt+1,sc+1);
		isSelected[cnt]=false;
		ps(cnt+1,sc);
		
	}
}