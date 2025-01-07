import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //숫자 개수
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N][21]; //dp[i][j]: i번째 숫자까지 계산해서 결과가 j가 되는 경우의 수

        dp[0][num[0]] = 1;

        for(int i = 0; i<N-1; i++){
            for(int j = 0; j<=20; j++){

                if(dp[i][j] != 0){
                    int plus = j + num[i+1];
                    int minus = j - num[i+1];

                    if(plus >= 0 && plus <= 20){
                        dp[i+1][plus] += dp[i][j];
                    }

                    if(minus >=0 && minus <= 20){
                        dp[i+1][minus] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[N-2][num[N-1]]);
    }
}