import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dp;
    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //작업 수
        dp = new int[N+1]; //작업을 완료하는데 필요한 최소 시간

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); //걸리는 시간
            int n = Integer.parseInt(st.nextToken()); //선행 관계에 있는 작업 수

            dp[i] = t; //현재 작업의 기본 시간 저장

            for(int j = 0; j<n; j++){
                int tmp = Integer.parseInt(st.nextToken());

                dp[i] = Math.max(dp[i], dp[tmp] + t); //선행 작업을 모두 완료해야 하기 때문에
            }

            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}