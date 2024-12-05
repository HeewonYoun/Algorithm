import java.io.*;
import java.util.*;

public class Main {

    static int N, E;
    static ArrayList<int[]>[] list;
    static int INF = 8000000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점 개수
        E = Integer.parseInt(st.nextToken()); //간선 개수

        list = new ArrayList[N+1];
        for(int i = 0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i= 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); //a~b 거리

            list[a].add(new int[]{b, c}); //양방향
            list[b].add(new int[]{a, c});
        }

        //반드시 거쳐야 하는 두 개의 서로 다른 정점 번호
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        //두개의 정점을 지나는 최단 경로의 길이
        int result = findPath(v1, v2);

        if(result == INF){
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static int findPath(int v1, int v2){
        int[] fromStart = d(1); //1번부터 다른 모든 정점까지의 최단 거리
        int[] fromV1 = d(v1); //v1부터 ~ 최단거리
        int[] fromV2 = d(v2); //v2부터 ~ 최단거리

        int path1 = fromStart[v1] + fromV1[v2] + fromV2[N];
        int path2 = fromStart[v2] + fromV2[v1] + fromV1[N];

        int result = Math.min(path1, path2);

        return result >= INF ? INF : result;
    }

    static int[] d(int start){ //다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            for(int[] e : list[cur[0]]){ //현재 정점과 연결된 인접정점 확인
                int newDist = dist[cur[0]] + e[1];

                if(dist[e[0]] > newDist){
                    dist[e[0]] = newDist;
                    pq.add(new int[]{e[0], dist[e[0]]});
                }
            }
        }
        return dist;
    }
}