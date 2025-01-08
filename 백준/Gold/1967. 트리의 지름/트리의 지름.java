import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Node>[] list;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    static class Node{
        int index;
        int dist;

        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //노드 개수

        list = new ArrayList[N+1];
        for(int i = 0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //부모노드
            int b = Integer.parseInt(st.nextToken()); //자식노드
            int dist = Integer.parseInt(st.nextToken()); //가중치

            list[a].add(new Node(b, dist));
            list[b].add(new Node(a, dist));
        }

        //임의의 노드에서 가장 먼 노드 찾기
        visited = new boolean[N+1];
        dfs(1, 0);

        //첫 번째 DFS에서 찾은 노드(farthestNode)에서 가장 먼 노드 찾기
        visited = new boolean[N+1];
        maxDist  = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int idx, int dist){
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = idx;
        }

        visited[idx] = true;

        for (Node next : list[idx]) {
            if (!visited[next.index]) {
                dfs(next.index, dist + next.dist);
            }
        }
    }
}