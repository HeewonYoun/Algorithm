import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] list;

    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //물건의 개수
        M = Integer.parseInt(br.readLine()); //미리 측정된 물건 쌍의 개수

        list = new List[N+1];
        for(int i = 0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){ //미리 측정된 비교 결과
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // a > b
            int b = Integer.parseInt(st.nextToken()); // a > b

            list[a].add(b);
        }

        //물건 i와 비교 결과를 알 수 없는 물건의 개수 출력
        count = new int[N+1]; //비교 결과 알 수 있는 물건의 개수
        for(int i = 1; i<=N; i++){
            visited = new boolean[N+1];
            dfs(i, i);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 1; i<=N; i++){
            sb.append(N - 1 - count[i]).append('\n');
        }
        System.out.println(sb);

    }

    static void dfs(int start, int cur){
        visited[cur] = true;

        for(int next : list[cur]){
            if(visited[next]) continue;

            count[start]++;
            count[next]++; 

            dfs(start, next);
        }
    }
}