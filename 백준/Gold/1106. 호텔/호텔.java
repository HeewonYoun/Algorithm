import java.io.*;
import java.util.*;

public class Main {

    static int C, N;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken()); //늘려야 하는 고객 수
        N = Integer.parseInt(st.nextToken()); //홍보할 수 있는 도시 개수

        dp = new int[C+101];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken()); //홍보비
            int count = Integer.parseInt(st.nextToken()); //얻을 수 있는 고객 수

            for(int j = count; j<C+101; j++){
                dp[j] = Math.min(dp[j], cost + dp[j-count]);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = C; i<C+101; i++){
            result = Math.min(result, dp[i]);
        }

        System.out.println(result);
    }
}