import java.io.*;
import java.util.*;

public class Main {

    static int w, h;
    static int[][] map;
    static int cheese;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken()); //세로
        w = Integer.parseInt(st.nextToken()); //가로

        map = new int[h][w];
        cheese = 0;

        for(int i = 0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<w; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheese++;
            }
        }

        int time = 0;
        int result = 0;

        while(cheese != 0) {
            visited = new boolean[h][w];
            result = cheese;
            bfs();
            time++;
        }

        System.out.println(time);
        System.out.println(result);
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= h || ny >=w) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                if(map[nx][ny] == 0){
                    q.offer(new int[]{nx, ny});
                } else {
                    cheese--;
                    map[nx][ny] = 0;
                }
            }

        }
    }
}