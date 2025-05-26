import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Edge> list = new ArrayList<>();

    static int[] parent;
    static long result;

    static class Edge implements Comparable<Edge> {

        int x;
        int y;
        int cost;

        Edge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y) parent[y] = x;
    }

    static int find(int x){
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j<=N; j++){
                int cost = Integer.parseInt(st.nextToken());

                list.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(list); //비용 적은 순으로 정렬

        parent = new int[N+1];
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }

        for(Edge edge : list){
            if(find(edge.x) != find(edge.y)){
                union(edge.x, edge.y);
                result += edge.cost;
            }
        }
        
        System.out.println(result);
    }
}
