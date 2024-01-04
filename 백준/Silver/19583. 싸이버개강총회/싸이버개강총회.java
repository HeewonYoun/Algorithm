import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//HH:MM
		int S = calTime(st.nextToken()); //개강총회를 시작한 시간
		int E = calTime(st.nextToken()); //개강총회를 끝낸 시간
		int Q = calTime(st.nextToken()); //개강총회 스트리밍을 끝낸 시간

		Map<String, Integer> map = new HashMap<>();
		
		int cnt = 0;
		String tmp;
		while((tmp = br.readLine()) != null) {
			st = new StringTokenizer(tmp);
			int time = calTime(st.nextToken());
			String name = st.nextToken();

			//입장 여부 확인
			if(!map.containsKey(name)) {
				if(time <= S) {
					map.put(name, 1); //입장여부
				} 
			} else { //입장 한 사람이라면
				if(E <= time && time <= Q) {
					cnt++;
					map.remove(name);
				}
			}	
		}
		System.out.println(cnt);
	}
	
	static int calTime(String str) {
		String[] tmp = str.split(":");
		int hour = Integer.parseInt(tmp[0]);
		int min = Integer.parseInt(tmp[1]);
		
		return hour*60+min;
	}
	
}