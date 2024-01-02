import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim()); //테스트 케이스 수
		
		for(int tc = 0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine().trim()); //해빈이가 가진 의상의 수
			
			Map<String, Integer> map = new HashMap<>();
			
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String clothes = st.nextToken();
				String group = st.nextToken();
				
				if(map.containsKey(group)) {
					map.replace(group, map.get(group)+1);
				} else {
					map.put(group, 1);
				}
			}
			
			int count = 1;
			for(String key : map.keySet()) {
				count *=  map.get(key) +1; //안입는 경우까지 포함해서 곱함
			}
			System.out.println(count-1);
		}
	}
}