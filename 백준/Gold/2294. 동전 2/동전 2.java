import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] coin;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //N가지 종류 동전
        K = Integer.parseInt(st.nextToken()); //합이 K

        coin = new int[N];
        for(int i = 0; i<N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K+1];
        Arrays.fill(dp, Integer.MAX_VALUE -1);
        dp[0] = 0;

        //동전 최소 사용
        for(int i = 0; i<N; i++){
            for(int j = coin[i]; j<=K; j++){
                dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1);
            }
        }

        if(dp[K] == Integer.MAX_VALUE -1){
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}
