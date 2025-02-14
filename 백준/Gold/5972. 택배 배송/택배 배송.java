import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<int[]>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //헛간개수
        M = Integer.parseInt(st.nextToken()); //소 길

        list = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken()); //비용

            list[A].add(new int[]{B, C});
            list[B].add(new int[]{A, C});
        }

        visited = new boolean[N+1];
        int[] dist = new int[N+1]; //최단거리 저장
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){ //비용 기준 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        dist[1] = 0; //1에서 시작
        pq.offer(new int[]{1, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;

            for(int i = 0; i<list[cur[0]].size(); i++){
                int[] next = list[cur[0]].get(i);

                if(dist[next[0]] > dist[cur[0]] + next[1]){
                    dist[next[0]] = dist[cur[0]] + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        System.out.println(dist[N]);
    }
}