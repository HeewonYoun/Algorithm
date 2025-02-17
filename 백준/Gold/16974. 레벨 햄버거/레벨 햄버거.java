import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long X;
    static long[] patty, total;
    static long result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //레벨N버거
        X = Long.parseLong(st.nextToken()); //햄버거 아래 X장 먹음

        total = new long[N+1]; //총 재료 수
        patty = new long[N+1]; //패티 수
        total[0] = 1;
        patty[0] = 1;

        for(int i = 1; i<=N; i++){ //레벨별 햄버거 재료 수와 패티 개수 계산
            total[i] = 1 + total[i-1] + 1 + total[i-1] + 1; //번 + 전버거+ 패티 + 전버거 + 번
            patty[i] = patty[i-1] + 1 + patty[i-1];
        }

        result = solution(N, X);
        System.out.println(result);
    }

    static long solution(int n, long x){
        if(n == 0){ //패티 1장인 경우
            if(x == 0) return 0;
            else if(x == 1) return 1;
        }

        if(x == 1){
            return 0;
        } else if(x <= 1 + total[n-1]){
            return solution(n-1, x-1);
        } else if(x == 1 + total[n-1] + 1){
            return patty[n-1] + 1;
        } else if(x <= 1 + total[n-1] + 1 + total[n-1]){
            return patty[n-1] + 1 + solution(n-1, x - (1 + total[n-1] + 1));
        } else{
            return patty[n-1]+1+patty[n-1];
        }
    }
}