import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //집 개수
        M = Integer.parseInt(st.nextToken()); //길 개수

        visited = new boolean[N+1];
        list = new List[N+1];
        for(int i = 0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); //a-b 연결하는 길의 유지비

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        //Prim 알고리즘으로 mst 구하고 mst에서 가장 가중치가 큰 간선 제외하기
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        pq.offer(new int[]{1, 0});
        int dist = 0; //총 비용
        int max = 0; //가장 큰 유지비

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;

            max = Math.max(max, cur[1]); //간선의 가중치를 최대값으로 갱신
            dist += cur[1];

            for(int[] next : list[cur[0]]){
                if(visited[next[0]]) continue;
                pq.offer(new int[]{next[0], next[1]});
            }
        }

        System.out.println(dist - max);
    }
}