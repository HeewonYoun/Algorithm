import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}; //상하좌우 , 위 왼오, 아래 왼오
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1}; //상하좌우 , 위 왼오, 아래 왼오
    static Map<String, Integer> map;
    static char[][] board;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); //신이 좋아하는 문자열 개수 (1<=K<=1000)
        // 1<=신이 좋아하는 문자열 길이<=5

        board = new char[N][M];

        for(int i = 0; i<N; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j<M; j++){
                board[i][j] = tmp[j];
            }
        }
        map = new LinkedHashMap<>();
        for(int i = 0; i<K; i++){
            String tmp = br.readLine().trim();
            if(!map.containsKey(tmp)){
                map.put(tmp, 0);
            }
        }

        //문자열을 만들 수 있는 경우의 수 순서대로 출력
        StringBuffer sb = new StringBuffer();

        for(String key : map.keySet()){
            char start = key.charAt(0);
            for(int i = 0; i<N; i++){
                for(int j = 0; j<M; j++){
                    if(board[i][j] == start){ //해당 위치의 문자가 문자열 시작 문자라면
                        dfs(i, j, 0, key);
                    }
                }
            }
            sb.append(map.get(key)).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cx, int cy, int cnt, String key){
        if(board[cx][cy] == key.charAt(cnt) && cnt == key.length()-1){
            map.replace(key, map.get(key)+1);
            return;
        }

        for(int i = 0; i < 8; i++ ){
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0) nx = N-1;
            if(ny < 0) ny = M-1;
            if(nx > N-1) nx = 0;
            if(ny > M-1) ny = 0;

            if(board[nx][ny] == key.charAt(cnt+1)){
                dfs(nx, ny, cnt + 1, key);
            }
        }
    }
}