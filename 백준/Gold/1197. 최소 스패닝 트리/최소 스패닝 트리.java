import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static List<Edge> list = new ArrayList<>();
    static int[] parents;

    public static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) { //오름차순 정렬
            return Integer.compare(this.weight, o.weight);
        }
    }

    static void makeSet(){
        for(int i = 1; i<V+1; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot){
            return false;
        }
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); //정점 개수
        E = Integer.parseInt(st.nextToken()); //간선 개수

        parents = new int[V+1];
        makeSet();

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken()); //가중치

            list.add(new Edge(A, B, C));
        }

        Collections.sort(list); //가중치 기준 오름차순 정렬

        int result = 0;
        int cnt = 0;

        for(Edge e : list){
            if(union(e.from, e.to)){
                result += e.weight;

                if(++cnt == V-1)
                    break;
            }
        }

        System.out.println(result);
    }
}