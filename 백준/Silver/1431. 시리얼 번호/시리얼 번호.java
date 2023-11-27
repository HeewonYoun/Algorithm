import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] serials = new String[N];
		for (int i = 0; i < N; i++) {
			serials[i] = br.readLine();
//			System.out.println(serials[i].length());
		}
		
		
		Arrays.sort(serials, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) { //1. 길이 순서대로 정렬
					return -1; //오름차순
				}else if(o1.length() == o2.length()) { //2. 길이 같으면 
					if(sum(o1) == sum(o2)) { //합도 같으면
						return o1.compareTo(o2);
					}else {
						return Integer.compare(sum(o1), sum(o2)); // 2. - 모든자리 수 합을 구해서 작은수로
					}
				}else { 
					return 1;
				}
			}
		});
		
		for(int i = 0; i<N; i++) {
			System.out.println(serials[i]);
		}
	}
	
	static int sum(String serial) {
		int sum = 0;
		char[] tmp = serial.toCharArray();
		for(int i = 0; i<tmp.length; i++) {
			if(tmp[i] >= 65 && tmp[i]<= 90) {
//				System.out.println(tmp[i]);
				continue;
			}else {
				sum += tmp[i] - '0';
			}
		}
//		System.out.println("총합:" + sum);
		return sum;
	}

}