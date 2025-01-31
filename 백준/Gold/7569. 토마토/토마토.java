import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static int result = 0;

    //상하좌우, 위 아래
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //열
        N = Integer.parseInt(st.nextToken()); //행
        H = Integer.parseInt(st.nextToken()); //쌓아올려지는 상자 수

        box = new int[H][N][M];

        int count = 0; //안익은 토마토 count
        Queue<int[]> q = new LinkedList<>();

        //익은거 1, 안익은거 0, 없는거 -1
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k<M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    if(box[i][j][k] == 0) count++;
                    else if(box[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        if (count == 0) { //저장될 때부터 모든 토마토가 익어있는 상태
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i<6; i++){
                int nh = cur[0] + dh[i];
                int nx = cur[1] + dx[i];
                int ny = cur[2] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || nh < 0 || nh >= H) continue;
                if(box[nh][nx][ny] == 0) {
                    q.offer(new int[]{nh, nx, ny});
                    box[nh][nx][ny] = box[cur[0]][cur[1]][cur[2]] + 1;
                }
            }
        }

        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++) {
                for (int k = 0; k<M; k++) {
                    if(box[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }

                    result = Math.max(result, box[i][j][k]);
                }
            }
        }

        System.out.println(result-1);
    }
}