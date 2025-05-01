import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[] parent;
    static List<Node> list;

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int dist;

        Node(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); //집 수
            N = Integer.parseInt(st.nextToken()); //길 수

            if(M == 0 && N ==0) break;

            list = new ArrayList<>();
            int result = 0;

            for(int i= 0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                result += cost;
                list.add(new Node(start, end, cost));
            }

            parent = new int[M];
            for(int i = 0; i<M; i++){
                parent[i] = i;
            }

            Collections.sort(list);

            for(Node cur : list){
                if (find(cur.start) != find(cur.end)){
                    union(cur.start, cur.end);

                    result -= cur.dist;
                }
            }

            System.out.println(result);
        }
    }

    static void union(int start, int end) {
        start = find(start);
        end = find(end);

        if(start != end){
            parent[end] = start;
        }
    }

    static int find(int start){
        if(parent[start] == start){
            return start;
        }

        return parent[start] = find(parent[start]);
    }
}
