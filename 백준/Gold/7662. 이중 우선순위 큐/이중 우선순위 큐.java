import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 0; tc<T; tc++) {
			int k = Integer.parseInt(br.readLine()); //Q에 적용할 연산의 개수
			
			PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minq = new PriorityQueue<>();
			HashMap<Integer,Integer> map = new HashMap<>();
			
			for(int i = 0; i<k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String calc = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(calc.equals("I")) {
					maxq.add(num);
					minq.add(num);
					
					if(map.containsKey(num)) {
						map.replace(num, map.get(num)+1);
					} else {
						map.put(num, 1);
					}
				} else if(calc.equals("D")) {
					if(num == -1 && !minq.isEmpty()) { //최솟값 삭제
						int tmp = Integer.MAX_VALUE;
						while(!minq.isEmpty()) {
							tmp = minq.poll();
							if(!map.containsKey(tmp)) continue;
							if(map.containsKey(tmp)) break;
						}
						if(map.containsKey(tmp)) {
							int cnt = map.get(tmp) - 1;
							if(cnt == 0) {
								map.remove(tmp);
							} else {
								map.replace(tmp, cnt);
							}
						}
					} else if(num == 1 && !maxq.isEmpty()){ //최댓값 삭제
						int tmp = Integer.MIN_VALUE;
						while(!maxq.isEmpty()) {
							tmp = maxq.poll();
							if(!map.containsKey(tmp)) continue;
							if(map.containsKey(tmp)) break;
						}
						if(map.containsKey(tmp)) {
							int cnt = map.get(tmp) - 1;
							if(cnt == 0) {
								map.remove(tmp);
							} else {
								map.replace(tmp, cnt);
							}
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				for(Integer key : map.keySet()) {
					if(key > max) {
						max = key;
					}
					if(key < min) {
						min = key;
					}
				}
				System.out.println(max + " " + min);
			}
		}
	}
}