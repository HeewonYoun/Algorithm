import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] dir = {{0, 1},{-1,0},{0,-1},{1,0}}; // 시작방향 d

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //드래곤 커브의 개수
        boolean [][] map = new boolean[101][101];

        ArrayList<int[]> start = new ArrayList<>();

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); //시작 방향
            int g = Integer.parseInt(st.nextToken()); //세대

            ArrayList<Integer> dirList = new ArrayList<>(); //방향 저장할 리스트
            dirList.add(d); //0세대 방향 넣기
            for(int j = 0; j<g; j++){ //g세대 까지 시계방향 90도 회전
                for(int k = dirList.size()-1; k>= 0; k--){ //뒤에서부터 반시계 방향으로
                    int dir = dirList.get(k);
                    if(dir == 3){
                        dirList.add(0);
                    } else {
                        dirList.add(dir+1);
                    }
                }
            }

            //표시
            map[x][y] = true;
            for(int j = 0; j<dirList.size(); j++){
                x = x + dir[dirList.get(j)][1];
                y = y + dir[dirList.get(j)][0];

                map[x][y] = true;
            }
        }

        //네모 개수 세기
        int result = 0;
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) result++;
            }
        }

        System.out.println(result);
    }
}