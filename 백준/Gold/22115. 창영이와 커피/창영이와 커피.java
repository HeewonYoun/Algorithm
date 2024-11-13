import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //커피개수
        K = Integer.parseInt(st.nextToken()); //카페인양

        C = new int[N]; //커피의 카페인 함유량
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            C[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; //카페인 0일때..

        for(int i = 0; i<N; i++){
            for(int j = K; j>=C[i]; j--){
                if(dp[j-C[i]] != Integer.MAX_VALUE){ //카페인 함유량 중복 사용하지 않게 뒤에서부터 갱신
                    dp[j] = Math.min(dp[j], dp[j-C[i]] + 1);
                }
            }
        }

        if(dp[K] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[K]);
    }
}