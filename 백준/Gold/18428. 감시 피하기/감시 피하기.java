import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<int[]> teachers = new ArrayList<int[]>(); //선생 리스트
    static ArrayList<int[]> students = new ArrayList<int[]>(); //학생 리스트

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        //선생T, 학생S, 장애물O
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = st.nextToken().charAt(0);

                if(map[i][j] == 'T'){
                    teachers.add(new int[]{i,j});
                } else if (map[i][j] == 'S') {
                    students.add(new int[]{i, j});
                }
            }
        }

        //X위치에 3개의 장애물 설치
        dfs(0);
        System.out.println("NO");
    }

    static void dfs(int count){
        if(count == 3){ //장애물 3개 설치했으면
            bfs();
            return;
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 'X'){
                    map[i][j] = 'O';
                    dfs(count + 1);

                    map[i][j] = 'X'; //원상복구
                }
            }
        }
    }

    static void bfs(){
        boolean[][] check = new boolean[N][N];
        char[][] copy = new char[N][N];
        Queue<int[]> q = new LinkedList<>();

        //배열 복사
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                copy[i][j] = map[i][j];

                if(copy[i][j] == 'T'){
                    q.add(new int[]{i, j}); //큐에 선생님 좌표 넣기
                    check[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                while(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(copy[nx][ny] != 'O'){ //장애물이 없으면
                        check[nx][ny] = true;
                        nx += dx[i];
                        ny += dy[i];
                    } else break;
                }
            }
        }

        if(check(check)){
            System.out.println("YES");
            System.exit(0);
        }
    }

    static boolean check(boolean[][] check){
        for(int[] cur : students){
            if(check[cur[0]][cur[1]]){ //감시 못피하는 학생 위치인 경우
                return false;
            }
        }

        return true;
    }
}