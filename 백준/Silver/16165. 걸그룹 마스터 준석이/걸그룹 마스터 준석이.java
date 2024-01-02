import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //입력 받을 걸그룹의 수
		int M = Integer.parseInt(st.nextToken()); //문제 수
		
		Map<String, String[]> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		
		for(int i = 0; i<N; i++) {
			String groupName = br.readLine().trim();
			int memCount = Integer.parseInt(br.readLine().trim());
			
			String[] memName = new String[memCount];
			// 멤버 이름 사전순으로 정렬할 수 있어야 함
			for(int j = 0; j<memCount; j++) {
				memName[j] = br.readLine().trim();
				map2.put(memName[j], groupName);
			}
			Arrays.sort(memName);
			map.put(groupName, memName);
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i<M; i++) {
			String quiz = br.readLine().trim();
			int num = Integer.parseInt(br.readLine().trim());
			
			if(num == 0) { // 팀 이름 주어짐 -> 멤버 이름 사전순으로 한 줄에 한명씩 출력
				String[] answer = map.get(quiz);
				for(int j = 0; j<answer.length; j++) {
					sb.append(answer[j]+"\n");
				}
				
			} else { //멤버 이름 주어짐-> 팀 이름 출력
				String answer = map2.get(quiz);
				sb.append(answer + "\n");
			}
		}
		System.out.println(sb);
	}
}