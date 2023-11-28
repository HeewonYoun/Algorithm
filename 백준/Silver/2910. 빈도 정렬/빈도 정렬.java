import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> numCnt = new LinkedHashMap<>(); //숫자 빈도수 저장
		 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if(numCnt.containsKey(tmp)) {
				numCnt.put(tmp, numCnt.get(tmp)+1);
			}else {
				numCnt.put(tmp, 1);
			}
		}
		
		List<Integer> msg = new ArrayList<>(numCnt.keySet()); //수열 넣을 리스트
		
		//X,Y 있을 때, X가 Y보다 수열에서 많이 등장하는 경우 X가 Y보다 앞에 있어야 함
		//횟수 같다면 먼저 나온것이 앞에
		Collections.sort(msg, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
					return Integer.compare(numCnt.get(o2), numCnt.get(o1));
			}
		});
		
		Iterator<Integer> it = msg.iterator();
		StringBuilder sb = new StringBuilder();
		
		while(it.hasNext()) {
			Integer element = it.next();
			for(int i = 0; i<numCnt.get(element);i++) {
				sb.append(element+" ");
			}
		}
		System.out.println(sb);
	}
}