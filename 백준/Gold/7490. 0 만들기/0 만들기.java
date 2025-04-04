import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            dfs(1,1,1,0,"1");
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void dfs(int cur, int num, int sign, int sum, String str){
        if(cur == N){
            sum = sum + (num * sign);

            if(sum == 0){ //합이 0이면 결과에 추가
                sb.append(str).append("\n");
            }
            return;
        }

        dfs(cur + 1, num *10 + (cur+1), sign, sum, str + " " + (cur + 1)); //숫자 이어붙이는 경우
        dfs(cur + 1, cur + 1, 1, sum + (num*sign), str + "+" + (cur + 1)); //+ 연산
        dfs(cur + 1, cur + 1, -1, sum + (num*sign), str + "-" + (cur + 1)); //- 연산
    }
}
