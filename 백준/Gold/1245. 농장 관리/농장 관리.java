import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;

    static boolean[][] visited;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; //8방향
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static boolean top;
    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //격자 내에 산봉우리의 개수가 총 몇 개인지
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(!visited[i][j] && map[i][j] != 0){ //방문한적 없고 0이 아닌 경우
                    top = true;
                    dfs(i, j);
                    if(top) result++;
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[x][y] < map[nx][ny]){
                top = false;
            }
            if(!visited[nx][ny] && map[nx][ny] == map[x][y]) dfs(nx, ny);
        }
    }
}
