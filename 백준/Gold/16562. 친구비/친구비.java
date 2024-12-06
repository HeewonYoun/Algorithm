import java.io.*;
import java.util.*;

public class Main {

    static int N, M, k;
    static int[] A;

    static List<Integer>[] list;
    static boolean[] visited;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //학생 수
        M = Integer.parseInt(st.nextToken()); //친구관계 수
        k = Integer.parseInt(st.nextToken()); //가지고 있는 돈

        A = new int[N+1]; //친구비
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        list = new List[N+1]; //친구 관계
        for(int i = 0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(v == w) continue;
            list[v].add(w);
            list[w].add(v);
        }

        visited = new boolean[N+1];

        for(int i = 1; i<=N; i++){
            if(!visited[i]){
                result += calc(i);
            }
        }

        if (result > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(result);
        }
    }

    static int calc(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int min = A[start];

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : list[cur]){
                if(visited[next]) continue;

                visited[next] = true;
                q.add(next);
                min = Math.min(min, A[next]); //연결되어있는 것 중에 최솟값으로
            }
        }

        return min;
    }
}