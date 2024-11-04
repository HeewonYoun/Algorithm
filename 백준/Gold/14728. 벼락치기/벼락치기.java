import java.io.*;
import java.util.*;

public class Main {

    static int N, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //시험 단원 개수
        T = Integer.parseInt(st.nextToken()); //공부 할 수 있는 총 시간

        int[][] study = new int[N+1][2];

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            study[i][0] = Integer.parseInt(st.nextToken()); //단원별 예상 공부 시간
            study[i][1] = Integer.parseInt(st.nextToken()); //단원 문제 배점

        }

        int[][] dp = new int[N+1][T+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j<=T; j++){
                if (study[i][0] <= j) { // 예상 공부 시간 이내일 때 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-study[i][0]] + study[i][1]);
                } else { //공부할수 없으면 이전값 그대로
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][T]);
    }
}