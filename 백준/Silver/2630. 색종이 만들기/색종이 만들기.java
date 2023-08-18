import java.util.*;
import java.io.*;

public class Main {
	
	static int [][] paper;
	static int white, blue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		d(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void d(int sx, int sy, int size) {
		int sum = 0;
		
		for(int i = sx; i<sx+size; i++) {
			for(int j = sy; j<sy+size; j++) {
				sum += paper[i][j];
			}
		}
		
		if(sum == size*size) {
			blue++;
		}else if(sum == 0) {
			white++;
		}else {
			d(sx, sy, size/2);
			d(sx, sy+size/2,size/2);
			d(sx+size/2, sy, size/2);
			d(sx+size/2, sy+size/2, size/2);
		}
		
		
	}
}
