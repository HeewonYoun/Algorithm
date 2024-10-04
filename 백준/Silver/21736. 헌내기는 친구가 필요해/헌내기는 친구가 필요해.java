import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0}; //상우하좌
    static int[] dy = {0, 1, 0, -1};

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        boolean checked = false;

        //o: 빈공간, x:벽, I:도연, p:사람
        for(int i = 0; i<N; i++){
            char[] tmp = br.readLine().toCharArray();
            map[i] = tmp;

            if(checked==false){
                for(int j = 0; j<M; j++){
                    if(map[i][j] == 'I'){
                        q.offer(new int[]{i, j});
                        visited[i][j] = true;
                        checked = true;
                        break;
                    }
                }
            }
        }

        int cx, cy;
        int result = 0; //만난 사람 수

        while(!q.isEmpty()){
            int[] cur = q.poll();
            cx = cur[0];
            cy = cur[1];

            if(map[cx][cy] == 'P') result++;

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;

            }

        }

        if(result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }
}