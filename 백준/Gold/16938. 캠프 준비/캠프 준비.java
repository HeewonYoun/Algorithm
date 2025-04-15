import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R, X;
    static int[] level;
    static int result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //문제 개수
        L = Integer.parseInt(st.nextToken()); // L <= 난이도 합 <= R
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()); // (가장 어려운 문제 - 가장 쉬운 문제 난이도) >= X

        level = new int[N+1]; //1번 문제부터 시작

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            level[i] = Integer.parseInt(st.nextToken());
        }

        //캠프에 사용할 문제를 고르는 방법의 수 출력
        visited = new boolean[N+1];
        for(int i = 1; i<= N; i++){
            visited[i] = true;
            dfs(i, level[i], level[i], level[i],1);
        }
        System.out.println(result);
    }

    static void dfs(int index, int levelSum, int max, int min, int count){
        if(count >= 2){
            if(levelSum >= L && levelSum <= R && (max - min) >= X){
                result++;
            }
        }

        for(int i = index + 1; i<=N; i++){
            if(levelSum + level[i] > R || visited[i]) continue;

            visited[i] = true;
            dfs(i, levelSum + level[i], Math.max(max, level[i]), Math.min(min, level[i]), count + 1);

            visited[i] = false;
        }
    }
}
