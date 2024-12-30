import java.io.*;
import java.util.*;

public class Main {

    static int N, S;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine()); //교환 가능 횟수

        for (int i = 0; i < N && S > 0; i++) {
            int maxIdx = i;

            //i에서 S안에서 이동 가능한 범위 내에서 최대값 찾기
            for (int j = i + 1; j < N && j - i <= S; j++) {
                if (num[j] > num[maxIdx]) {
                    maxIdx = j;
                }
            }

            //최대값이 i와 같지 않으면 교환
            if (maxIdx != i) {
                //최대값을 i 위치로 이동
                for (int j = maxIdx; j > i; j--) {
                    int tmp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = tmp;
                }

                S -= (maxIdx - i); //교환 횟수 업데이트
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(num[i] + " ");
        }
    }
}