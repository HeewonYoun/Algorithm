import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Bus>[] list;

    static int[] dist;
    static boolean[] visited;

    static int s, e;

    static class Bus implements Comparable<Bus>{
        int end;
        int cost;

        Bus(int end, int cost){
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //도시 수
        M = Integer.parseInt(br.readLine()); //버스 수

        list = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(s);

        System.out.println(dist[e]);
    }

    static void dijkstra(int start){
        Queue<Bus> q = new PriorityQueue<>();

        q.add(new Bus(s, 0));
        dist[s] = 0; //시작도시는 비용 0

        while(!q.isEmpty()){
            Bus cur = q.poll();

            if(visited[cur.end]) continue;

            visited[cur.end] = true;
            for(Bus next: list[cur.end]){
                if(dist[next.end] >= dist[cur.end] + next.cost){ //더 작은 비용인 경우
                    dist[next.end] = dist[cur.end] + next.cost; //갱신
                    q.add(new Bus(next.end, dist[next.end]));
                }
            }
        }
    }

}
