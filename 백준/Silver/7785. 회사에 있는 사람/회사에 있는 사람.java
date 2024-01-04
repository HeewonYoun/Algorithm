import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 출입 기록 수
		
		Map<String, String> map = new HashMap<>();
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String record = st.nextToken();
			
			if(map.containsKey(name)) {
				map.remove(name);
			}else {
				map.put(name, record);
			}
		}
		
		List<String> list = new ArrayList<>();
		for(String name : map.keySet()) {
			list.add(name);
		}
		Collections.sort(list, Collections.reverseOrder());
		StringBuffer sb = new StringBuffer();
		for(String name : list) {
			sb.append(name + "\n");
		}
		System.out.println(sb);
	}
}