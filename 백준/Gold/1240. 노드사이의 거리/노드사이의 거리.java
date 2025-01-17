import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]>[] list;
    static int result;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //노드 수
        M = Integer.parseInt(st.nextToken()); //거리를 알고싶은 노드 쌍의 수

        list = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, cost});
            list[b].add(new int[]{a, cost});
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new boolean[N+1];

            visited[a] = true;
            dfs(a, b, 0);
            System.out.println(result);
        }
    }

    static void dfs(int from, int to, int sum){
        if(from == to){
            result = sum;
            return;
        }

        for(int[] cur : list[from]){
            if(visited[cur[0]]) continue;

            visited[cur[0]] = true;
            dfs(cur[0], to, sum + cur[1]);

            visited[cur[0]] = false;
        }
    }
}