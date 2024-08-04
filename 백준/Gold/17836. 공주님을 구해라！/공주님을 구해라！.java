import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][][] visited;
    static int N, M, T;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[2][N][M];
        int result = bfs(0,0);

        if(result == -1){
            System.out.println("Fail");
            return;
        }

        System.out.println(result);
    }

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,0,0});
        visited[0][x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];
            int hasGram = cur[2]; // 검
            int time = cur[3]; // 이동시간

            if(time > T){
                break;
            }

            if(curx == N-1 && cury == M-1){
                return time;
            }

            for(int i = 0; i<4; i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(hasGram == 0) {
                    if(map[nx][ny] == 0 && !visited[0][nx][ny]){
                        q.add(new int[]{nx, ny, hasGram, time+1});
                        visited[0][nx][ny] = true;
                    } else if(map[nx][ny] == 2 && !visited[0][nx][ny]){
                        q.add(new int[]{nx, ny, hasGram+1, time+1});
                        visited[0][nx][ny] = true;
                    }
                } else {
                    if(!visited[1][nx][ny]){
                        q.add(new int[]{nx, ny, hasGram, time+1});
                        visited[1][nx][ny] = true;
                    }
                }
            }
        }
    return -1;
    }

}