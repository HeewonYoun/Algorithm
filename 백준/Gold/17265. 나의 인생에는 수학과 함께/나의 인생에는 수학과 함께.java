import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;

    static int[] dx = {0, 2, 1}; //우, 하, 하우, 우하
    static int[] dy = {2, 0, 1};

    static int[][] minMap;
    static int[][] maxMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        minMap = new int[N][N];
        maxMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Arrays.fill(minMap[i], Integer.MAX_VALUE);
            Arrays.fill(maxMap[i], Integer.MIN_VALUE);

            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        //연산 결과의 최댓값, 최솟값 출력 (연산자 우선순위 고려 X)
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, map[0][0] - '0', 0});
        minMap[0][0] = map[0][0] - '0';
        maxMap[0][0] = map[0][0] - '0';

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int num = cur[2];

            if(cx != 0 || cy != 0){
                if (cur[3] == 0) { //왼쪽에서 온 경우
                    //바로 이전 연산자
                    int minCalc = calc(map[cx][cy - 1], minMap[cx][cy - 2], num); //최소 계산
                    int maxCalc = calc(map[cx][cy - 1], maxMap[cx][cy - 2], num); //최대 계산

                    minMap[cx][cy] = Math.min(minCalc, minMap[cx][cy]);
                    maxMap[cx][cy] = Math.max(maxCalc, maxMap[cx][cy]);

                } else if (cur[3] == 1) { //위에서 온 경우
                    //바로 위 연산자
                    int minCalc = calc(map[cx - 1][cy], minMap[cx - 2][cy], num); //최소 계산
                    int maxCalc = calc(map[cx - 1][cy], maxMap[cx - 2][cy], num); //최대 계산

                    minMap[cx][cy] = Math.min(minCalc, minMap[cx][cy]);
                    maxMap[cx][cy] = Math.max(maxCalc, maxMap[cx][cy]);


                } else { //왼쪽 위에서 온 경우
                    //바로 위 연산자
                    int minCalc = calc(map[cx][cy - 1], minMap[cx - 1][cy - 1], num); //최소 계산
                    int maxCalc = calc(map[cx][cy - 1], maxMap[cx - 1][cy - 1], num); //최대 계산

                    minMap[cx][cy] = Math.min(minCalc, minMap[cx][cy]);
                    maxMap[cx][cy] = Math.max(maxCalc, maxMap[cx][cy]);

                    //바로 위 연산자
                    minCalc = calc(map[cx-1][cy], minMap[cx - 1][cy - 1], num); //최소 계산
                    maxCalc = calc(map[cx-1][cy], maxMap[cx - 1][cy - 1], num); //최대 계산

                    minMap[cx][cy] = Math.min(minCalc, minMap[cx][cy]);
                    maxMap[cx][cy] = Math.max(maxCalc, maxMap[cx][cy]);

                }
            }

            for (int i = 0; i < 3; i++) { //우 0, 하 1, 우하2이동
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= N || ny >= N) continue;
                q.offer(new int[]{nx, ny, map[nx][ny] - '0', i});
            }
        }

        System.out.println(maxMap[N - 1][N - 1] + " " + minMap[N - 1][N - 1]);
    }

    static int calc(char operator, int before, int cur) {
        switch (operator) {
            case '+':
                return before + cur;
            case '-':
                return before - cur;
            case '*':
                return before * cur;
        }
        return 0;
    }
}