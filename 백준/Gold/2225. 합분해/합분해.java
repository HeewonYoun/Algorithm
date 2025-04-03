import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] sum;
    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //K개 더해서 합이 N이 되는 경우의 수

        sum = new int[N+1][K+1];

        for(int i = 1; i<=K; i++){
            sum[0][i] = 1; //0을 i개의 숫자로 만드는 경우는 1개
        }

        for(int i = 1; i<= N; i++){
            for(int j = 1; j<= K; j++){
                sum[i][j] = (sum[i-1][j] + sum[i][j-1]) % MOD;
            }
        }

        System.out.println(sum[N][K]);
    }
}
