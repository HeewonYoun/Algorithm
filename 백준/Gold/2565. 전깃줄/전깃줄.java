import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] line;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //전깃줄 개수
        line = new int[N][2];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, new Comparator<int[]>() { //왼쪽 전봇대 기준 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] dp = new int[N];
        int result = 0;

        //최장 증가 부분수열
        //전깃줄이 겹치지 않으면서 가장 긴 전깃줄의 개수 구하기
        for(int i = 0; i<N; i++){
            dp[i] = 1; //최소 개수 1

            for(int j = 0; j<i; j++){
                if(line[i][1] > line[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }

        System.out.println(N - result);
    }
}