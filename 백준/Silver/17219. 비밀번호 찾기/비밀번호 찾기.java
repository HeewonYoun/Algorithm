import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>(); //사이트 주소 비밀번호(알파벳 대문자)
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();
			
			map.put(site, pw);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i<M; i++) {
			String awnser = map.get(br.readLine().trim());
			
			bw.append(awnser+"\n");
		}
		
		bw.flush();
	}
}