import java.util.*;
import java.io.*;

public class Main {

	static int L, C;
	static char[] res, alph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); // 암호 길이
		C = Integer.parseInt(st.nextToken()); // 조교들 사용했을법한 문자종류

		alph = new char[C];
		res = new char[L];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			alph[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alph);
		dfs(0, 0, 0);

	}

	// 최소 한개의 모음(aeiou), 최소 두개의 자음으로 구성
	static void dfs(int idx, int start, int cnt) {
		if (cnt == L) {
			int cntz = 0;
			int cntm = 0;
			for (int i = 0; i < L; i++) {
				if (res[i] == 'a' || res[i] == 'e' || res[i] == 'i' || res[i] == 'o' || res[i] == 'u') {
					cntm++;
				} else {
					cntz++;
				}
			}
			
			if(cntm >= 1 && cntz >= 2) {
				System.out.println(res);
			}
			return;
		}

		for (int i = start; i < C; i++) {
			res[idx] = alph[i];
			dfs(idx + 1, i + 1, cnt + 1);
		}
	}
}
