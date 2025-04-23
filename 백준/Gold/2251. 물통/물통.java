import java.io.*;
import java.util.*;

public class Main {

    static int A,B,C;
    static int[] from = {0, 0, 1, 1, 2, 2}; //출발 물통
    static int[] to = {1, 2, 0, 2, 0, 1}; //도착 물통

    static boolean[][][] visited;
    static boolean[] result; //A 물통이 비어있을 때 C물통 물양

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        A = Integer.parseInt(st.nextToken()); //부피
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[A+1][B+1][C+1];
        result = new boolean[C+1];

        bfs();

        for(int i = 0; i<=C; i++){
            if(result[i]){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, C});
        visited[0][0][C] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == 0) result[cur[2]] = true; //A 물통이 비어있을 때 C물양 기록

            for(int i = 0; i<6; i++){
                int[] next = {cur[0], cur[1], cur[2]};

                //물 따르기
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;

                if (next[to[i]] > new int[]{A, B, C}[to[i]]) { //넘치는 경우
                    next[from[i]] = next[to[i]] - new int[]{A, B, C}[to[i]];
                    next[to[i]] = new int[]{A, B, C}[to[i]];
                }

                if (!visited[next[0]][next[1]][next[2]]) {
                    visited[next[0]][next[1]][next[2]] = true;
                    q.offer(next);
                }
            }
        }
    }
}
