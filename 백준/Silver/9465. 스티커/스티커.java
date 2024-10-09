import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, n;
    static int[][] sticker;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++){
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n];
            dp = new int[2][n];

            for(int i = 0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //첫번째 열 최대는 그자리 그대로
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            int max = Math.max(dp[0][0], dp[1][0]);

            if(n == 1) {
                System.out.println(max);
                continue;
            }

            dp[0][1] = dp[1][0] + sticker[0][1];
            dp[1][1] = dp[0][0] + sticker[1][1];
            max = Math.max(dp[0][1], dp[1][1]);

            if(n == 2){
                System.out.println(max);
                continue;
            }

            for(int i = 2; i<n; i++){

                //0행에서 시작하는게 큰지 1행에서 시작하는게 큰지 비교
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i];
                max = Math.max(dp[0][i], dp[1][i]);
            }

            System.out.println(max);
        }
    }
}