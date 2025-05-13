import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] arrI;
    static int[] arrT;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //최대 공부시간
        K = Integer.parseInt(st.nextToken()); //과목 수

        arrI = new int[K];
        arrT = new int[K];

        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            arrI[i] = Integer.parseInt(st.nextToken()); //중요도
            arrT[i] = Integer.parseInt(st.nextToken()); //필요한 공부시간
        }

        dp = new int[K+1][N+1]; //i번째 과목까지 고려했을 때 j시간 안에 얻을 수 있는 최대 중요도 합
        for(int i = 1; i<=K; i++){
            int imp = arrI[i-1];
            int time = arrT[i-1];

            for(int j = 1; j<= N; j++){
                dp[i][j] = dp[i-1][j];

                if(j-time >= 0){ //과목을 선택할 수 있는 시간일 때
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time] + imp);
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}
