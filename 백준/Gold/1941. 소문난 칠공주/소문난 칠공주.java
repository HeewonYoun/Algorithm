import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] map = new char[5][5];
    static int result = 0;

    static int[] dx = {-1, 0, 1, 0}; //상우하좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<5; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j<5; j++){
                map[i][j] = tmp[j]; //S:이다솜파, Y:임도연파
            }
        }

        //조합 - 25개 자리 중 7개 뽑기
        c(0, 0, new ArrayList<>());
        System.out.println(result);
    }

    static void c(int start, int count, List<int[]> selected){
        if(count == 7){
            if(isValid(selected)){
                result++;
            }
            return;
        }

        for(int i = start; i<25; i++){
            int x = i / 5;
            int y = i % 5;

            selected.add(new int[]{x,y});
            c(i+1, count+1, selected);

            selected.remove(selected.size()-1);
        }
    }

    static boolean isValid(List<int[]> selected){
        int cntS = 0;
        boolean[][] visited = new boolean[5][5];

        for(int[] cur : selected){
            if(map[cur[0]][cur[1]] == 'S') cntS++;
        }
        if(cntS < 4) return false;

        //BFS로 연결성 확인
        Queue<int[]> q = new LinkedList<>();
        q.add(selected.get(0));
        visited[selected.get(0)[0]][selected.get(0)[1]] = true;
        int cntConn = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

                for (int[] pos : selected) {
                    if (pos[0] == nx && pos[1] == ny && !visited[nx][ny]) { //선택된것 중에  nx, ny인 것
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        cntConn++;
                    }
                }
            }
        }
        return (cntConn == 7);
    }
}