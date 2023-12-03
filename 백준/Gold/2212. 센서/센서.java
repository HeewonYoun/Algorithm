import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()); //센서 개수
		int K = Integer.parseInt(br.readLine().trim()); //집중국 개수
		
		int[] sensor = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensor); // 센서 거리 정렬
		
		//센서 거리 차이 담은 배열 - 내림차순 정렬
		int[] diff = new int[N-1];
		for(int i = 0; i<N-1; i++) {
			diff[i] = sensor[i+1] - sensor[i]; 
		}
		
		int sum = 0;
		Arrays.sort(diff);
		for(int i = 0; i<N-K; i++) {
			sum += diff[i];
		}
		System.out.println(sum);
	}
}