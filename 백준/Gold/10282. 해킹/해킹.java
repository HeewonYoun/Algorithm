import java.io.*;
import java.util.*;

public class Main{

    static int T;
    static int n, d, c;

    static List<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    public static class Node implements Comparable<Node> {

        int a;
        int s;

        Node(int a, int s){
            this.a = a;
            this.s = s;
        }

        @Override
        public int compareTo(Node o) { //감염시간 기준 오름차순
            return Integer.compare(this.s, o.s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); //컴퓨터 개수
            d = Integer.parseInt(st.nextToken()); //의존성 개수
            c = Integer.parseInt(st.nextToken()); //해킹당한 컴퓨터 번호

            list = new ArrayList[n+1];
            for(int i = 1; i<=n; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i<d; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken()); //a가 b 의존
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken()); //b감염 시 s 초후 a 감염

                list[b].add(new Node(a, s));
            }

            int count = 0;
            int sec = 0;
            dist = new int[n+1];
            visited = new boolean[n+1];

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(c, 0));

            while(!pq.isEmpty()){
                Node cur = pq.poll();

                if(visited[cur.a]) continue;

                visited[cur.a] = true;
                count++;

                for(Node next : list[cur.a]){
                    if(dist[next.a] > dist[cur.a] + next.s){ //더 짧은 시간에 감염될 수 있으면
                        dist[next.a] = dist[cur.a] + next.s;
                        pq.offer(new Node(next.a, dist[next.a]));
                    }
                }
            }

            for(int i = 1; i<=n; i++){
                if(dist[i] != Integer.MAX_VALUE){
                    sec = Math.max(dist[i], sec);
                }
            }

            sb.append(count).append(" ").append(sec).append("\n");
        }

        System.out.println(sb);
    }
}
