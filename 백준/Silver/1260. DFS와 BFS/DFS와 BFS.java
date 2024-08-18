import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //간선 개수
        V = Integer.parseInt(st.nextToken()); //탐색 시작할 번호
        map = new int[N+1][N+1];

        for(int i = 0; i<M; i++){ //간선이 연결하는 두 정점의 번호
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);
        Arrays.fill(visited, false);
        System.out.println();
        bfs();

    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");

            for(int i = 1; i<=N; i++){
                if(map[cur][i] != 1) continue;
                if(visited[i]) continue;
                visited[i] = true;
                q.offer(i);
            }
        }
    }

    static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");

        for(int i = 1; i<=N; i++){
            if(map[start][i] != 1) continue;
            if(visited[i]) continue;
            dfs(i);
        }
    }
}