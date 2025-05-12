import java.io.*;
import java.util.*;

public class Main {

    static int L, N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken()); //학교까지 거리
        int N = Integer.parseInt(st.nextToken()); //킥보드 충전소 개수
        int K = Integer.parseInt(st.nextToken()); //최대 충전소 방문 횟수

        int[] arr = new int[N + 2]; //충전소 위치
        arr[0] = 0; //시작
        arr[N + 1] = L; //도착

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int diff = -1;
        for (int i = 1; i <= N + 1; i++) {
            diff = Math.max(diff, arr[i] - arr[i - 1]); //인접한 충전소 사이 거리 중 최대값
        }

        int result = L;
        int left = diff;
        int right = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0; //충전소 방문 횟수
            int last = 0; //마지막 충전 위치

            for (int i = 1; i <= N + 1; i++) {
                if (arr[i] - last > mid) {
                    count++;

                    if (arr[i] - last == mid) {
                        last = arr[i];

                    } else {
                        last = arr[i - 1];
                    }
                }
            }

            if (count > K) { //충전소 방문 횟수 K 초과하면
                left = mid + 1; //배터리 용량 늘림
            } else {
                right = mid - 1;
                result = Math.min(result, mid);
            }
        }

        System.out.println(result);
    }
}
