import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //선을 그은 횟수
		
		List<int[]> list = new ArrayList<int[]>();
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmpx = Integer.parseInt(st.nextToken());
			int tmpy = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {tmpx, tmpy});
		}
		
        //정렬하면 경우의 수가 3개로 줄어듦
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];					
				}
			}
		});
		
		int x = list.get(0)[0];
		int y = list.get(0)[1];
		long result = Math.abs(y-x);
		
		for(int i = 1; i<N; i++) {
			int[] cur = list.get(i);
			
			if(cur[0] >= x && cur[0] <= y) {
				if(cur[1] <= y) { //완전히 포함되는 경우
					continue;					
				} else if (cur[1] > y) { //걸치는 경우
					result += Math.abs(cur[1]-y);
					y = cur[1];
					continue;
				}
			}
			
			//겹치지 않는 경우
			if(cur[0] >= y) {
				result += Math.abs(cur[1] - cur[0]);
				x = cur[0];
				y = cur[1];
				continue;
			}
		}
		System.out.println(result);
	}
}