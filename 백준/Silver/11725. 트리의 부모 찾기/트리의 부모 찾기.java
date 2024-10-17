import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        List<Integer> list[] = new List[N+1];
        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
            list[a].add(b);
        }

        //부모 찾기
        int[] parent = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1); //루트노드부터 시작
        visited[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : list[cur]){
                if(visited[i]) continue;
                visited[i] = true;
                parent[i] = cur;
                q.add(i);
            }
        }

        for(int i = 2; i<= N ; i++){
            System.out.println(parent[i]);
        }
    }
}