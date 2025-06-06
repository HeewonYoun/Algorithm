import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int [][] map;
    static int [][][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //필요한 연료 최솟값
        dp = new int[N][M][3];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i = 0; i<M; i++){
            for(int j = 0; j<3; j++){
                dp[0][i][j] = map[0][i]; //초기값 세팅
            }
        }

        //0: 왼쪽, 1: 가운데, 2: 오른쪽
        for(int i = 1; i<N; i++){
            for(int j = 0; j<M; j++){
                if(j == 0){ //가운데, 오른쪽
                    dp[i][j][1] = dp[i-1][j][2] + map[i][j]; //가운데
                    dp[i][j][2] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][0]) + map[i][j]; //오른쪽

                } else if (j < M-1){ //왼쪽, 가운데, 오른쪽
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + map[i][j];

                } else { //왼쪽, 가운데
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + map[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + map[i][j];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i<M; i++){
            for(int j = 0; j<3; j++){
                result = Math.min(result, dp[N-1][i][j]);
            }
        }
        System.out.println(result);
    }
}