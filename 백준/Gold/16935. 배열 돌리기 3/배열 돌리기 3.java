import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); // 연산의 수

		int[][] list = new int[N][M];
		for (int i = 0; i < list.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < list[0].length; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] tmp;

		// 수행해야 하는 연산
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int opn = Integer.parseInt(st.nextToken());

			switch (opn) {
			case 1: // 1: 상하반전
				
				tmp = new int[list.length][list[0].length];
				
				for (int j = 0; j < list.length; j++) {
					for (int k = 0; k < list[0].length; k++) {
						tmp[list.length - 1 - j][k] = list[j][k];
					}
				}
				list = tmp;
				break;
			case 2: // 2: 좌우반전

				
				tmp = new int[list.length][list[0].length];
				
				for (int j = 0; j < list.length; j++) {
					for (int k = 0; k < list[0].length; k++) {
						tmp[j][list[0].length - 1 - k] = list[j][k];
					}
				}
				list = tmp;
				break;
			case 3: // 3: 오른쪽 90도 회전

				
				tmp = new int[list[0].length][list.length];
				for (int j = 0; j < list.length; j++) {
					for (int k = 0; k < list[0].length; k++) {
						tmp[k][list.length-1-j] = list[j][k];
					}
				}
				list = tmp;
				break;
			case 4: // 4: 왼쪽 90도 회전

				
				tmp = new int[list[0].length][list.length];
				for (int j = 0; j < list.length; j++) {
					for (int k = 0; k < list[0].length; k++) {
						tmp[list[0].length-1-k][j] = list[j][k];
					}
				}
				list = tmp;
				break;
			case 5: // 5:

				
				tmp = new int[list.length][list[0].length];
				//6x8
				//1) 0,0 ~ N/2-1,M/2-1
				//2) 0,M/2 ~ N/2-1,M-1
				//3) N/2,M/2 ~ N-1,M-1
				//4) N/2,0 ~ N/2-1,M/2-1
				
				for(int j = 0; j<list.length/2; j++) { // 1->2
					for(int k=0; k<list[0].length/2; k++) {
						tmp[j][k+list[0].length/2] = list[j][k];
					}
				}
				
				for(int j = 0; j<list.length/2; j++) { // 2->3
					for(int k=list[0].length/2; k<list[0].length; k++) {
						tmp[j+list.length/2][k] = list[j][k];
					}
				}
				
				for(int j = list.length/2; j<list.length; j++) { // 3->4
					for(int k=list[0].length/2; k<list[0].length; k++) {
						tmp[j][k-list[0].length/2] = list[j][k];
					}
				}
				
				for(int j = list.length/2; j<list.length; j++) { // 4->1
					for(int k=0; k<list[0].length/2; k++) {
						tmp[j-list.length/2][k] = list[j][k];
					}
				}
				list = tmp;
				break;
			case 6: // 6:

				
				tmp = new int[list.length][list[0].length];
				
				for(int j = 0; j<list.length/2; j++) { // 1->4
					for(int k=0; k<list[0].length/2; k++) {
						tmp[j+list.length/2][k] = list[j][k];
					}
				}
				
				for(int j = 0; j<list.length/2; j++) { // 2->1
					for(int k=list[0].length/2; k<list[0].length; k++) {
						tmp[j][k-list[0].length/2] = list[j][k];
					}
				}
				
				for(int j = list.length/2; j<list.length; j++) { // 3->2
					for(int k=list[0].length/2; k<list[0].length; k++) {
						tmp[j-list.length/2][k] = list[j][k];
					}
				}
				
				for(int j = list.length/2; j<list.length; j++) { // 4->3
					for(int k=0; k<list[0].length/2; k++) {
						tmp[j][k+list[0].length/2] = list[j][k];
					}
				}
				list = tmp;
				
				break;
			}
		}
		for (int i = 0; i < list.length; i++) {
			for(int j = 0; j < list[0].length; j++) {
				System.out.print(list[i][j]+" ");
			}
			System.out.println();
		}

	}

}
