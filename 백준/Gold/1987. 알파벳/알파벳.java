import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0}; //상우하좌
    static int[] dy = {0, 1, 0, -1};

    static int R, C;
    static char[][] map;
    static int result = 0;
//    static HashMap<Character, Integer> alpha = new HashMap<>(); -> 알파벳 개수에 비해 메모리를 많이 사용함
//    static boolean[][] visited; 알파벳이 중복되지 않으면 자동으로 칸의 중복 방문이 방지됨 -> 없어도 문제 없음

    static boolean[] visited = new boolean[26]; //알파벳 방문 체크


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); //행
        C = Integer.parseInt(st.nextToken()); //열

        map = new char[R][C];

        for(int i = 0; i<R; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j<C; j++){
                map[i][j] = tmp[j];
            }
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0,0, 1);

        System.out.println(result);
    }

    static void dfs(int sx, int sy, int cnt){
        result = Math.max(result, cnt);

        //반복 & 원상복구
        for(int i = 0; i<4; i++){
            int nx = sx + dx[i];
            int ny = sy + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(visited[map[nx][ny] - 'A']) continue; //방문체크

            visited[map[nx][ny]-'A'] = true;
            dfs(nx, ny, cnt + 1);

            visited[map[nx][ny]-'A'] = false;
        }
    }
}