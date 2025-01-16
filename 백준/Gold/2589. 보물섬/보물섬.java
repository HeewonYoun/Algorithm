import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int result = 0;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0}; //상우하좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        map = new char[N][M]; //보물섬 지도 - 육지 L, 바다 W
        for(int i = 0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] == 'L'){
                    visited = new boolean[N][M];
                    int time = bfs(i, j);
                    result = Math.max(time, result);
                }
            }
        }

        System.out.println(result);
    }

    static int bfs(int cx, int cy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cx, cy, 0});
        visited[cx][cy] = true;

        int time = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny] || map[nx][ny] == 'W') continue;

                q.offer(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
                time = Math.max(time, cur[2]+1); //현재까지 계산된 최장 이동 시간 갱신
            }
        }

        return time;
    }
}