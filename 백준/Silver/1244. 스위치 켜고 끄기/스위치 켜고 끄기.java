import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 스위치 개수
		int[] sw = new int[n]; // 스위치 상태
		for (int i = 0; i < n; i++) {
			sw[i] = sc.nextInt();
		}

		int st; // 학생수
		st = sc.nextInt();

		for (int i = 0; i < st; i++) {
			int gender = sc.nextInt(); // 성별
			int sn = sc.nextInt(); // 스위치 번호

			if (gender == 1) { // 남자일때
				for (int j = sn - 1; j < n; j++) {
					if ((j + 1) % sn == 0) {
						sw[j] = (sw[j] == 0)?1:0;
					}
				}
			} else { // 여자일때
				int c_r = sn; // 받은 수의 오른쪽
				int c_l = sn - 2; // 받은 수의 왼쪽
				while (c_r <= n-1 && c_l >= 0 && sw[c_r] == sw[c_l]) {
					if (sw[c_r] == 0) {
						sw[c_r] = 1;
						sw[c_l] = 1;
					} else if (sw[c_r] == 1) {
						sw[c_r] = 0;
						sw[c_l] = 0;
					}
					c_r++;
					c_l--;
				}
				sw[sn - 1] = (sw[sn - 1] == 0) ? 1 : 0;
			}
		}
		//20개씩 출력
		for (int j = 0; j < n; j++) {
			System.out.print(sw[j] + " ");
			if((j+1)%20==0) {
				System.out.println();
			}
		}
	}
}