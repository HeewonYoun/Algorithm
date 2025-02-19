import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] score;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        score = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        //조가 잘 짜여진 정도의 최댓값
        int[] dp = new int[N+1];

        for(int i = 1; i<=N; i++){
            int max = score[i];
            int min = score[i];

            for(int j = i; j>0; j--){
                max = Math.max(max, score[j]);
                min = Math.min(min, score[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j-1]);
            }
        }

        System.out.println(dp[N]);
    }
}