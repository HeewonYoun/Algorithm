import java.io.*;
import java.util.*;

public class Main { // 불!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()); // 미로 행의 개수
        int C = Integer.parseInt(st.nextToken()); // 미로 열의 개수
        char[][] maze = new char[R][C];
        Queue<int[]> jq = new ArrayDeque<int[]>(); // 지훈큐
        Queue<int[]> fq = new ArrayDeque<int[]>(); // 불큐

        int[][] jt = new int[R][C]; // 지훈 전파시간 배열
        int[][] ft = new int[R][C]; // 불 전파시간 배열
        

        boolean[][] jvis = new boolean[R][C];
        boolean[][] fvis = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                maze[i][j] = tmp[j];
                jt[i][j] = -1;
                ft[i][j] = -1;

                if (tmp[j] == 'J') { // 지훈이 미로에서 초기위치
                    jq.offer(new int[] { i, j });
                    jt[i][j] = 0;
                    jvis[i][j] = true;
                }

                if (tmp[j] == 'F') { // 불 초기 위치
                    fq.offer(new int[] { i, j });
                    ft[i][j] = 0;
                    fvis[i][j] = true;
                }

            }
        }

        int[] dx = { -1, 0, 1, 0 }; // 상우하좌
        int[] dy = { 0, 1, 0, -1 };


        // 불이랑 지훈이랑 따로 하고 시간 비교해서 결과 출력
        
        // 불 진행
        while (!fq.isEmpty()) {
            int xx = fq.peek()[0];
            int yy = fq.peek()[1];
            fq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || maze[nx][ny] == '#') continue;
                if (fvis[nx][ny]) continue;
                if (maze[nx][ny] == '.' || maze[nx][ny] == 'J') {
                    ft[nx][ny] = ft[xx][yy] +1;
                    fvis[nx][ny] = true;
                    fq.offer(new int[] { nx, ny });
                }
            }
        }

        int res = -1;
        // 지훈 진행
        while (!jq.isEmpty()) {
            int xx = jq.peek()[0];
            int yy = jq.peek()[1];
            jq.poll();

            if (xx == R - 1 || xx == 0 || yy == C - 1 || yy == 0){// 지훈이는 미로의 가장자리 접한 공간 > x가 r-1이거나 0, y가 c-1이거나 0일때 탈출가능
                res = jt[xx][yy]+1;
                break; 
            }
            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];
                
                //조건에 불의 전파 시간을 추가
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || maze[nx][ny] == '#' || maze[nx][ny] == 'F') continue;
                if (jvis[nx][ny]) continue;
                if(ft[nx][ny]<=jt[xx][yy]+1 && ft[nx][ny]!=-1) continue;
                if (maze[nx][ny] == '.') {
                    jt[nx][ny] = jt[xx][yy] + 1;
                    jvis[nx][ny] = true;
                    jq.offer(new int[] { nx, ny });
                }
            }
        }
        
        if(res < 0) {
        	System.out.println("IMPOSSIBLE");
        }else {
        	System.out.println(res);
        }
        
    }

}
