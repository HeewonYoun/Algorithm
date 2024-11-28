import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] map;
    static int[] plan;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //도시의 수
        M = Integer.parseInt(br.readLine()); //여행 계획에 속한 도시들의 수

        map = new int[N+1][N+1];

        //도시 연결 정보
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); //1연결, 0연결X
            }
        }

        //여행 계획
        plan = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=M; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }

        //가능하면 YES, 아니면 NO 출력
        //중간에 다른 도시 경유해서 여행 가능, 같은 도시 여러번 방문 가능

        Queue<Integer> q = new LinkedList<>();
        q.offer(plan[1]);
        boolean[] visited = new boolean[N+1];
        visited[plan[1]] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 1; i<=N; i++){
                int next = map[cur][i];

                if(map[cur][i] == 0) continue;
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }

        for(int i = 1; i<= M; i++){
            if(!visited[plan[i]]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}