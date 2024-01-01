import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		for(int i = 0; i<L; i++) {
			String tmp = br.readLine().trim();
			
			if(map.containsKey(tmp)) {
				map.remove(tmp);
				map.put(tmp, i);
			} else {
				map.put(tmp, i);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = 1;
		for(String key : map.keySet()) {
			bw.append(key + "\n");
			if(count == K ) {
				break;
			}
			count++;
		}
		
		bw.flush();
	}
}