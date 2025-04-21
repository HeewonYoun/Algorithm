import java.io.*;
import java.util.*;

public class Main {

    static String word;
    static int result;

    static int[][][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();
        String devil = br.readLine(); //악마돌다리
        String angel = br.readLine(); //천사돌다리

        dp = new int[2][word.length()+1][devil.length()+1];
        Arrays.fill(dp[0][0] ,1);
        Arrays.fill(dp[1][0] ,1);

        for(int i = 1; i<=word.length(); i++){ //암호 i 번째 문자
            for(int j = 1; j<=devil.length(); j++){ //돌다리 j번째 위치
                if(word.charAt(i-1) == devil.charAt(j-1)){ //악마돌다리랑 일치할 때
                    dp[0][i][j] = dp[0][i][j-1] + dp[1][i-1][j-1]; //현재 다리 경로 + 다른 다리

                } else dp[0][i][j] = dp[0][i][j-1]; //일치하지 않으면 이전 돌까지 값대로

                if(word.charAt(i-1) == angel.charAt(j-1)){ //천사돌다리 일치할 때
                    dp[1][i][j] = dp[1][i][j-1] + dp[0][i-1][j-1];

                } else dp[1][i][j] = dp[1][i][j-1];
            }
        }

        result = dp[0][word.length()][devil.length()] + dp[1][word.length()][devil.length()];

        //돌다리를 통과할 수 있는 모든 가능한 방법의 수
        System.out.println(result);
    }
}
