import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;
    static int[][] dp;

    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //가로
        M = Integer.parseInt(st.nextToken()); //세로

        map = new int[N][M];
        dp = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    static int dfs(int x, int y){
        if(x == N-1 && y == M-1) {
            return 1; //도착했을경우
        }

        if(dp[x][y] != -1){
            return dp[x][y]; //방문한 경우
        }

        dp[x][y] = 0;
        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[x][y] > map [nx][ny]){ //높이가 낮은 지점으로만 이동
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}