import java.io.*;
import java.util.*;

public class Main {

    static int N, M, S, E;
    static int[] num;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //수열크기
        num = new int[N+1];
        dp = new boolean[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=N; i++){ //하나는 항상 팰린드롬
            dp[i][i] = true;
        }

        for(int i = 1; i<N; i++){ //연속된 두 수가 같으면 팰린드롬
            if(num[i] == num[i+1]) dp[i][i+1] = true;
        }

        for(int i = 2; i<N; i++){ //양 끝이 같고 그 사이 구간이 팰린드롬이면 팰린드롬
            for(int j = 1; j<= N-i; j++){
                if(num[j] == num[j+i] && dp[j+1][j+i-1]){
                    dp[j][j+i] = true;
                }
            }
        }

        M = Integer.parseInt(br.readLine()); //질문개수
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            //팰린드롬: 순서를 거꾸로 읽었을 때도 원래의 문자열이나 수열과 동일한 경우
            //S번째 ~ E번째까지 수가 팰린드롬을 이루는지

            if(dp[S][E]) sb.append(1).append('\n'); //팰린드롬인 경우
            else sb.append(0).append('\n'); //아닌경우
        }

        System.out.println(sb);
    }
}
