import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] board;
    static int[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //사다리 수
        M = Integer.parseInt(st.nextToken()); //뱀 수

        board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i; // 기본적으로 자기 자신을 가리키도록 초기화
        }

        for(int i = 0; i<N; i++){ //사다리 정보
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        for(int i = 0; i<M; i++){ //뱀 정보
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[u] = v;
        }

        //주사위 최소 몇번 굴려야 하는지
        bfs();
        System.out.println(check[100]);
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        check = new int[101];

        q.offer(1);

        while(true){
            int cur = q.poll();

            for(int i = 1; i<=6; i++){
                int next = cur + i;

                if(next > 100) continue;
                if(check[board[next]] != 0) continue;

                q.offer(board[next]);
                check[board[next]] = check[cur] + 1;

                if(board[next] == 100) return;
            }
        }
    }
}