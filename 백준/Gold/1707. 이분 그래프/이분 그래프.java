import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static List<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); //정점 수
            E = Integer.parseInt(st.nextToken()); //간선 수

            visited = new int[V+1];
            list = new ArrayList[V+1];
            for(int j = 1; j<=V; j++){
                list[j] = new ArrayList<>();
            }

            for(int j = 0; j<E; j++){ //간선 정보
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list[u].add(v);
                list[v].add(u);
            }

            bfs();
        }
    }

    static void bfs(){ //이분그래프 확인
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 1; i<=V; i++){
            if(visited[i] == 0){
                q.add(i);
                visited[i] = 1;
            }

            while(!q.isEmpty()){
                int cur = q.poll();

                for(int j = 0; j<list[cur].size(); j++){ //현재 정점의 인접 정점 순회
                    int next = list[cur].get(j);

                    if(visited[next] == 0){ //방문한 적 없을 경우
                        q.add(next);

                        if(visited[cur] == 1){
                            visited[next] = 2;
                        } else if (visited[cur] == 2){
                            visited[next] = 1;
                        }
                    }

                    if(visited[next] == visited[cur]){ //같은 그룹에 속해 있다면
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}