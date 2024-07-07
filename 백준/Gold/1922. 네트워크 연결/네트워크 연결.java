import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수

        ArrayList<int[]>[] list = new ArrayList[n+1];
        for(int i = 0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 각 컴퓨터를 연결하는데 드는 비용
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken()); //비용

            list[a].add(new int[]{b,cost});
            list[b].add(new int[]{a,cost});
        }

        //모든 컴퓨터를 연결하는데 필요한 최소 비용
        boolean[] visited = new boolean[n+1];
        int sum = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        pq.add(new int[]{1,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(!visited[cur[0]]){
                visited[cur[0]] = true;
                sum += cur[1];

                for(int j = 0; j<list[cur[0]].size(); j++){
                    if(!visited[list[cur[0]].get(j)[0]]){
                        pq.add(list[cur[0]].get(j));
                    }
                }
            }
        }
        System.out.println(sum);
    }
}