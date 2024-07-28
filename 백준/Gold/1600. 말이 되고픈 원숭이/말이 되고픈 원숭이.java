import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dhx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dhy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); //K번만 말처럼 움직일 수 있음

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];

        for(int i = 0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //(0,0) ~ (H-1,W-1)

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[H][W][K+1]; //[][][말 이동 횟수]

        visited[0][0][0] = true;
        q.add(new int[]{0, 0, 0, 0}); // x, y, 말, 전체이동
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            int k = cur[2];
            int cnt = cur[3];

            if(cx == H-1 && cy == W-1) {
                System.out.println(cnt);
                return;
            }

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy  +dy[i];

                if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if(visited[nx][ny][k]) continue;

                if(map[nx][ny] != 1){
                    visited[nx][ny][k] = true;
                    q.add(new int[]{nx, ny, k, cnt+1});
                }
            }

            //말 이동
            if(k < K){
                for(int i = 0; i<8; i++){
                    int nx = cx + dhx[i];
                    int ny = cy  +dhy[i];

                    if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                    if(visited[nx][ny][k+1]) continue;

                    if(map[nx][ny] != 1){
                        visited[nx][ny][k+1] = true;
                        q.add(new int[]{nx, ny, k+1, cnt+1});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}