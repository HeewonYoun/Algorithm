import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // N <= 50

		List<Integer> pnum = new ArrayList<>(); // 양수 리스트
		List<Integer> nnum = new ArrayList<>(); // 음수 리스트

		if (N == 1) { // N == 1인 경우
			System.out.println(Integer.parseInt(br.readLine()));
			return;
		}

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp > 0) {
				pnum.add(tmp);
			} else {
				nnum.add(tmp);
			}
		}

		// 정렬
		pnum.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		nnum.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		long sum = 0;

		for (int i = 0; i < pnum.size();) {
			if (i == pnum.size() - 1) { // 마지막 원소면
				sum += pnum.get(i);
				break;
			} else if(pnum.get(i+1) == 1) { //마지막 수가 1이면
				sum += pnum.get(i) + pnum.get(i+1);
				i += 2;
			} else {
				sum += pnum.get(i) * pnum.get(i + 1);
				i += 2;
			}
		}
		
		for(int i = 0; i< nnum.size();) {
			if (i == nnum.size() - 1) { // 마지막 원소면
				sum += nnum.get(i);
				break;
			} else {
				sum += nnum.get(i) * nnum.get(i + 1);
				i += 2;
			}
		}
		System.out.println(sum);
	}
}