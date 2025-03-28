import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int n, m;

    static List<Integer>[] list;
    static int[] color;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //동그라미 개수
            m = Integer.parseInt(st.nextToken()); //직선 개수

            check = false;
            color = new int[n+1];
            list = new LinkedList[n+1];
            for(int i = 0; i<= n ; i++){
                list[i] = new LinkedList<>();
            }

            for(int i = 0; i<m; i++){ //연결된 직선 정보
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken()); //동그라미 x와 동그라미 y가 직선으로 연결되었다는 의미

                list[x].add(y);
                list[y].add(x);
            }

            for(int i = 1; i<=n; i++){
                if(color[i] == 0) bfs(i);
                if(check) break;
            }

            if(check) sb.append("impossible").append("\n");
            else sb.append("possible").append("\n");
        }

        System.out.println(sb);

    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 0; i<list[cur].size(); i++){
                int next = list[cur].get(i);

                if(color[next] == 0){
                    q.add(next);
                    color[next] = color[cur] * (-1);
                } else if (color[next] + color[cur] != 0){
                    check = true;
                    return;
                }
            }
        }
    }
}
