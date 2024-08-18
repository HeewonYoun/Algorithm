import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static ArrayList<int[]> store;
    static ArrayList<int[]> home;
    static ArrayList<int[]> select = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //최대 치킨집 개수
        map = new int[N+1][N+1];
        store = new ArrayList<>();
        home = new ArrayList<>();

        //0: 빈칸, 1: 집, 2: 치킨집
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    store.add(new int[]{i,j}); //치킨 집
                } else if (map[i][j] == 1){
                    home.add(new int[]{i,j}); //집
                }
            }
        }

        //치킨거리: 집과 가장 가까운 치킨집 사이의 거리
        //도시의 치킨거리: 모든 집의 치킨 거리의 합

        visited = new boolean[store.size()];
        dfs(0,0);
        System.out.println(result);

    }

    static void dfs(int cnt, int start){
        if(cnt == M){
            int sum = 0;
            //치킨거리 계산
            for(int i = 0; i<home.size(); i++){
                int min = Integer.MAX_VALUE;
                for(int j = 0; j<select.size(); j++){
                    int d = Math.abs(home.get(i)[0] - select.get(j)[0]) + Math.abs(home.get(i)[1] - select.get(j)[1]);
                    min = Math.min(d, min);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for(int i = start; i<store.size(); i++){

            if(!visited[i]){
                visited[i] = true;
                select.add(store.get(i));
                dfs(cnt+1, i+1);
                select.remove(store.get(i)); //원상복구
                visited[i] = false;
            }
        }
    }
}