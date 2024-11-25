import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] visible;
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visible = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){ //각 분기점이 적의 시야에 보이는지 ( 0: 안보임, 1:보임 ) / 상대편넥서스는 보이면서 갈 수 있는곳
            visible[i] = Integer.parseInt(st.nextToken());
        }

        list = new List[N];
        for(int i = 0; i<N; i++){
            list[i] = new ArrayList<>();
        }

        for(int j = 0; j<M; j++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken()); //a~b 사이를 지나는데 걸리는 시간

            list[a].add(new int[]{b, t});
            list[b].add(new int[]{a, t});
        }

        //안 들키고 가는데 걸리는 최소 시간 출력
        //불가능하면 -1 출력
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]); //걸리는 시간 빠른 순서대로
            }
        });

        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cx = cur[0];
            int ctime = cur[1];

            if(ctime > dist[cx]) continue;

            for(int[] nx : list[cx]){
                int next = nx[0]; //다음 노드
                int ntime = nx[1]; //까지 가는데 걸리는 시간

                if(visible[next] == 1 && next != N-1) continue;

                if(dist[cx] + ntime < dist[next]){
                    dist[next] = dist[cx] + ntime;
                    pq.add(new int[]{next, (int)dist[next]});
                }
            }
        }

        if(dist[N-1] == Long.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(dist[N-1]);
        }

    }
}