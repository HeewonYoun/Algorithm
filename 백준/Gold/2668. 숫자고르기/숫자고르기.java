import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] num;

    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        for(int i = 1; i<=N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N+1];
        for(int i = 1; i<=N; i++){
            visited[i] = true;
            dfs(i, i);

            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    static void dfs(int idx, int start){
        if(!visited[num[idx]]){
            visited[num[idx]] = true;
            dfs(num[idx], start);

            visited[num[idx]] = false;
        }

        if(num[idx] == start) list.add(start);
    }
}