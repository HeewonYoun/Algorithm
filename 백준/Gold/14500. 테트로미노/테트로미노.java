import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //4개 칸 골랐을 때 수들의 합의 최댓값
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);

                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    static void dfs(int cx, int cy, int cnt, int sum){
        if(cnt == 4){
            result = Math.max(result, sum);
            return;
        }

        //상하좌우 탐색
        for(int i = 0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visited[nx][ny]) continue;

            // ㅗ
            if(cnt == 2){
                visited[nx][ny] = true;
                dfs(cx, cy, cnt+1, map[nx][ny] + sum);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, cnt+1,sum+map[nx][ny]);

            visited[nx][ny] = false;
        }
    }
}