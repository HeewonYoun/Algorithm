import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Node>[] list;
    static boolean[] visited;
    static int result;

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

        for(int i = 1; i<=N; i++){
            visited = new boolean[N+1];

            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(result);
    }

    static void dfs(int idx, int sum){
        result = Math.max(result, sum);

        for(Node next : list[idx]){
            if(visited[next.index]) continue;

            visited[next.index] = true;
            dfs(next.index, sum + next.dist);

            visited[next.index] = false;
        }
    }
}