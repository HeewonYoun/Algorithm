import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0}; //상우하좌
    static int[] dy = {0, 1, 0, -1};

    static int R, C;
    static char[][] map;
    static int result = Integer.MIN_VALUE;
    static HashMap<Character, Integer> alpha = new HashMap<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); //행
        C = Integer.parseInt(st.nextToken()); //열

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i<R; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j<C; j++){
                map[i][j] = tmp[j];
            }
        }

        visited[0][0] = true;
        alpha.put(map[0][0], 1);
        dfs(0,0, 1);

        System.out.println(result);
    }

    static void dfs(int sx, int sy, int cnt){
        if(cnt > result){
            result = cnt;
        }

        //반복 & 원상복구
        for(int i = 0; i<4; i++){
            int nx = sx + dx[i];
            int ny = sy + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(visited[nx][ny]) continue;
            if(alpha.containsKey(map[nx][ny])) continue;

            visited[nx][ny] = true;
            alpha.put(map[nx][ny] , 1);
            dfs(nx, ny, cnt + 1);

            visited[nx][ny] = false;
            alpha.remove(map[nx][ny]);
        }
    }
}