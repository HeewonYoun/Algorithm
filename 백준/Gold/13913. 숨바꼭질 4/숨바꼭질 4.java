import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        int[][] map = new int[2][100001];

        for(int i = 0; i<2; i++){
            Arrays.fill(map[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0}); //{현재 좌표, 초}
        map[0][N] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int sec = cur[1];

            if(cx == K){
                System.out.println(sec);

                //경로 - 뒤에서부터
                int[] path = new int[sec+1];
                int idx = sec;
                while(cx != N){
                    path[idx--] = cx;
                    cx = map[1][cx]; // 이전 경로
                }
                path[0] = N;

                for(int i = 0; i<= sec; i++){
                    System.out.print(path[i] + " ");
                }
                return;
            }

            for(int i = 0; i<3; i++){
                int nx = cx + dx[i];
                if(i == 2){
                    nx = cx * dx[i];
                }

                if(nx < 0 || nx > 100000) continue;
                if(map[0][nx] != -1){
                    if(map[0][nx] > sec + 1){
                        map[0][nx] = sec + 1;
                        map[1][nx] = cx;
                        q.offer(new int[]{nx, sec+1});
                    }
                } else {
                    map[0][nx] = sec + 1;
                    map[1][nx] = cx;
                    q.offer(new int[]{nx, sec+1});
                }
            }
        }
    }
}