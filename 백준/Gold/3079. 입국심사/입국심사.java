import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //입국심사대 개수
        M = Integer.parseInt(st.nextToken()); //인원 수
        time = new int[N];

        for(int i = 0; i<N; i++){
            time[i] = Integer.parseInt(br.readLine());
        }

        //이분탐색
        long left = 0;
        long right = (long)time[N-1] * M; //최대 시간의 경우
        long result = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;

            // 각 심사대에서 mid 시간 동안 처리할 수 있는 사람 수를 계산
            for (int t : time) {
                total += mid / t;
                if (total >= M) break; // 이미 M명을 처리할 수 있으면 더 볼 필요 없음
            }

            if (total >= M) { // M명 이상을 처리할 수 있는 경우
                result = mid; // 최솟값 갱신
                right = mid - 1; // 더 적은 시간으로 가능한지 확인
            } else {
                left = mid + 1; // 시간을 늘려야 함
            }
        }

        System.out.println(result);
    }
}