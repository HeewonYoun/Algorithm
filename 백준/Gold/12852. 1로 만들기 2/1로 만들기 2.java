import java.io.*;
import java.util.*;

public class Main {

    static int X;
    static int[] dp;
    static int[] trace;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());

        dp = new int[X+1];
        trace = new int[X+1];

        dp[0] = dp[1] = 0;
        for(int i = 2; i <= X; i++){
            dp[i] = dp[i-1] + 1;
            trace[i] = i-1;

            if(i%3 == 0 && dp[i/3] + 1 < dp[i]){
                dp[i] = dp[i/3] + 1;
                trace[i] = i / 3;
            }

            if(i%2==0 && dp[i/2] + 1 < dp[i]){
                dp[i] = dp[i/2] + 1;
                trace[i] = i/2;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[X]).append('\n');
        while(X>0){
            sb.append(X+ " ");
            X = trace[X];
        }
        System.out.println(sb);
    }
}