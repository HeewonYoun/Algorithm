import java.io.*;
import java.util.*;

public class Main {

    static boolean[] isVisited;
    static ArrayList<Integer>[] list;
    static int dest, dist, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        isVisited = new boolean[n+1];

        for(int i = 0; i<= n ; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs();
        System.out.println(dest+" "+dist+" "+cnt);

    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        isVisited[1] = true;
        q.offer(new int[]{1,0});

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int cur = arr[0];
            int cur_dist = arr[1]; //현재 거리

            if(cur_dist > dist){ //현재 거리값이 더 크면
                dist = cur_dist; //최종 거리
                dest = cur; //최종 헛간 번호
                cnt = 1; //개수 초기화
            } else if(cur_dist == dist){
                if(dest > cur) {
                    dest = cur;
                }
                cnt++;
            }

            for(int i = 0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                if(!isVisited[next]){
                    isVisited[next] = true;
                    q.offer(new int[]{next,cur_dist+1});
                }
            }
        }
    }
}