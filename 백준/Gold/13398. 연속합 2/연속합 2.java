import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] num;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][2]; //0: 수 제거 안하는 경우, 1: 수 제거하는 겨우
        dp[0][0] = dp[0][1] = num[0];

        int result = num[0];

        for(int i = 1; i<N; i++){
            //수를 제거하지 않는 경우
            dp[i][0] = Math.max(dp[i-1][0] + num[i], num[i]);

            //dp[i-1][0]: i번째 수가 처음 제거되는 경우 (현재 수 제거하는 경우)
            //dp[i-1][1] + num[i]: i번째 수 전에 지워진 수가 있는 경우
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+num[i]);

            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(result);
    }
}
