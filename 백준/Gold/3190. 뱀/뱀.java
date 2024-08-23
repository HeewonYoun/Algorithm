import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1}; //우하좌상
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //보드 크기
        int K = Integer.parseInt(br.readLine()); //사과 개수
        int[][] board = new int[N+1][N+1]; //사과 있는 곳은 1

        for(int i = 0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; //사과 위치
        }

        int L = Integer.parseInt(br.readLine()); //뱀의 방향 변환 횟수
        HashMap<Integer, Character> change = new HashMap<>(); //(키: 초, 값: 방향)
        for(int i = 0; i<L; i++){ //X초 끝난 뒤에 왼쪽(L), 또는 오른쪽(D)로 90도 방향 회전
            StringTokenizer st = new StringTokenizer(br.readLine());
            change.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        int time = 0;
        int d = 0; //방향

        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{1,1});

        loop: while(true){
            int nx = snake.get(snake.size()-1)[0] + dx[d];
            int ny = snake.get(snake.size()-1)[1] + dy[d];

            int[] next = new int[]{nx,ny};

            //벽인지 체크 -> 벽이면 게임 끝
            if(nx < 1 || ny < 1 || nx > N || ny > N) break;
            //자기 자신인지 체크 -> 게임 끝
            for(int i = 0; i<snake.size(); i++){
                if(Arrays.equals(snake.get(i), next)) break loop;
            }

            //사과 있는지 체크 -> 길이 늘려서 추가하거나 늘리지 않고 다음칸 이동
            if(board[nx][ny] != 1) {
                snake.remove(0);
            } else {
                board[nx][ny] = 0; //사과 먹으면 지우기
            }
            snake.add(new int[]{nx, ny});
            time++;

            //방향 바꿀 시간인지 체크 (X초 끝난 후 회전) -> 방향 변환
            if(change.containsKey(time)){
                if(change.get(time) == 'L'){ //왼쪽으로 회전
                    d = d -1 ;
                    if(d == -1) d = 3;
                } else { //오른쪽으로 회전
                    d = (d+1)%4;
                }
            }
        }

        System.out.println(time+1);
    }
}