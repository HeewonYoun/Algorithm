import java.io.*;
import java.util.*;

public class Main {

    static char[][] map = new char[12][6];
    static int result;

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static class Puyo {
        int x, y;
        char color;

        Puyo(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while (true) {
            boolean anyPopped = false; //연쇄 발생 여부
            boolean[][] visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        List<int[]> list = new ArrayList<>(); //터트릴 후보 위치 리스트
                        Queue<Puyo> q = new LinkedList<>();

                        q.add(new Puyo(i, j, map[i][j]));
                        visited[i][j] = true;
                        list.add(new int[]{i, j});

                        while (!q.isEmpty()) {
                            Puyo cur = q.poll();

                            for (int k = 0; k < 4; k++) {
                                int nx = cur.x + dx[k];
                                int ny = cur.y + dy[k];

                                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                                if (visited[nx][ny]) continue;

                                if (map[nx][ny] == cur.color) { //같은 색상의 뿌요가 붙어 있는 경우
                                    q.add(new Puyo(nx, ny, map[nx][ny]));
                                    visited[nx][ny] = true;
                                    list.add(new int[]{nx, ny});
                                }
                            }
                        }

                        if (list.size() >= 4) { //4개 이상 연결된 뿌요가 있는 경우
                            for (int[] pos : list) {
                                map[pos[0]][pos[1]] = '.'; //터뜨리기
                            }
                            anyPopped = true; //연쇄가 발생 ture
                        }
                    }
                }
            }

            if (!anyPopped) break;

            update(); //중력 작용
            result++; //연쇄 수 증가
        }

        System.out.println(result);
    }

    static void update() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] == '.') { //현재 칸이 빈칸이면 뿌요 떨어뜨림
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != '.') {
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
