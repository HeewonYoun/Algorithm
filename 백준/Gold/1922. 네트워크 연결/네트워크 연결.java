import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //컴퓨터 수
        M = Integer.parseInt(br.readLine()); //선의 수

        list = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); //a,b 연결하는데 드는 비용

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]); //비용 적은 순서
            }
        });

        boolean[] visited = new boolean[N+1];
        int result = 0;
        pq.add(new int[]{1,0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(!visited[cur[0]]){
                visited[cur[0]] = true;
                result += cur[1];

                for(int i = 0; i<list[cur[0]].size(); i++){
                    if(!visited[list[cur[0]].get(i)[0]]){
                        pq.add(list[cur[0]].get(i));
                    }
                }
            }
        }

        System.out.println(result);
    }
}