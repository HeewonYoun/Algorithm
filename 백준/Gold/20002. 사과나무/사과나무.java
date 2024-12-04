import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] sum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        sum = new int[N+1][N+1];

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + map[i][j];
            }
        }

        // K*K 크기의 정사각형 모양으로 수확했을 때 최대 총이익
        int result = Integer.MIN_VALUE;
        int k = 0;

        while(k++ < N){
            for(int i = k; i <= N; i++){
                for(int j = k; j<=N; j++){
                    int profit = sum[i][j] - sum[i-k][j] - sum[i][j-k] + sum[i-k][j-k];
                    result = Math.max(result, profit);
                }
            }
        }

        System.out.println(result);
    }
}