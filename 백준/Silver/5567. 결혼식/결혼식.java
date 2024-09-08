import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static int n, m;
    static int result = 0; //상근이의 결혼식에 초대하는 동기의 수
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); //동기 수
        m = Integer.parseInt(br.readLine()); //리스트의 길이

        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i = 1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){ //친구 관계
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());

            list[tmp1].add(tmp2);
            list[tmp2].add(tmp1);
        }

        if(list[1].size() == 0){
            System.out.println(0);
            return;
        }

        visited[1] = true;
        dfs(0, 1);

        for(int i = 2; i<=n; i++){
            if(visited[i]) result++;
        }

        System.out.println(result);
    }

    static void dfs(int d, int cur){
        if(d == 2){ //친구의 친구일 때
            return;
        }

        for(int i = 0; i<list[cur].size(); i++){
            int friend = list[cur].get(i);

            visited[friend] = true;
            dfs(d+1, friend);
        }
    }
}