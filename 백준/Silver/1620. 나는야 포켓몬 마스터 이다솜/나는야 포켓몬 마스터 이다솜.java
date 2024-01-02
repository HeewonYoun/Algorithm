import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //도감에 수록되어 있는 포켓몬 개수
		int M = Integer.parseInt(st.nextToken()); //맞춰야 하는 문제 개수

		HashMap<String, String> map1 = new HashMap<>(); //키가 포켓몬 이름
		HashMap<String, String> map2 = new HashMap<>(); //키가 포켓몬 번호
		
		for(int i = 1; i<N+1; i++) {
			String name = br.readLine().trim();
			
			map1.put(name, Integer.toString(i));
			map2.put(Integer.toString(i), name);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i<M; i++) {
			String tmp = br.readLine().trim();
			if(map1.containsKey(tmp)) {
				bw.append(map1.get(tmp)+"\n");
			} else {
				bw.append(map2.get(tmp)+"\n");
			}
		}
		bw.flush();
	}
}
