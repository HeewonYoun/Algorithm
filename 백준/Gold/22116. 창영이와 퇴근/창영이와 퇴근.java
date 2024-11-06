import java.io.*;
import java.util.*;

public class Main {

    static int N; //격자 크기
    static int[][] map;
    static int[][] dist;

    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N]; //최댓값 저장

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        //최소 경사부터 탐색
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(cur[0] == N-1 && cur[1] == N-1){
                System.out.println(cur[2]);
                return;
            }

            //경사 계산
            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                //인접한 격자 사이 높이 차이의 절댓값 - 경사
                int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                int max = Math.max(cur[2], diff); //최대 경사 구하기

                if(max < dist[nx][ny]){ //각 경로의 최대 경사의 최솟값
                    dist[nx][ny] = max;
                    pq.add(new int[]{nx, ny, max});
                }
            }
        }
    }
}