import java.io.*;
import java.util.*;

public class Main {

    static int R, C, T;
    static int[][] map;
    static Queue<int[]> q; //미세먼지
    static List<int[]> air = new ArrayList<>(); //공기청정기

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        q = new LinkedList<>();

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] > 0) q.offer(new int[]{i, j, map[i][j]});
                else if(map[i][j] == -1) air.add(new int[]{i, j});
            }
        }

        for(int t = 0; t < T; t++){
            spread(); //미세먼지 확신
            operateAirCleaner();

            q.clear();
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(map[i][j] > 0) q.offer(new int[]{i, j, map[i][j]});
                }
            }
        }

        int result = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] > 0) result += map[i][j];
            }
        }
        System.out.println(result);
    }

    static void spread(){
        int[][] temp = new int[R][C];

        for(int[] pos : air){
            temp[pos[0]][pos[1]] = -1;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], amount = cur[2];
            int count = 0; //확산된 방향수

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;

                temp[nx][ny] += amount / 5;
                count++;
            }

            temp[x][y] += amount - (amount / 5 * count);
        }

        map = temp;
    }

    static void operateAirCleaner(){ //공기청정기 작동
        int upper = air.get(0)[0];
        int lower = air.get(1)[0];

        // 위쪽 반시계방향
        for(int i = upper - 1; i > 0; i--) map[i][0] = map[i-1][0];
        for(int i = 0; i < C - 1; i++) map[0][i] = map[0][i+1];
        for(int i = 0; i < upper; i++) map[i][C-1] = map[i+1][C-1];
        for(int i = C - 1; i > 1; i--) map[upper][i] = map[upper][i-1];
        map[upper][1] = 0;

        // 아래쪽 시계방향
        for(int i = lower + 1; i < R - 1; i++) map[i][0] = map[i+1][0];
        for(int i = 0; i < C - 1; i++) map[R-1][i] = map[R-1][i+1];
        for(int i = R - 1; i > lower; i--) map[i][C-1] = map[i-1][C-1];
        for(int i = C - 1; i > 1; i--) map[lower][i] = map[lower][i-1];
        map[lower][1] = 0;
    }
}
