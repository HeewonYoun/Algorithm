import java.io.*;
import java.util.*;

public class Main {

    static int count =0, score=Integer.MAX_VALUE;
    static ArrayList<Integer>[] score_list;
    static ArrayList<Integer>[] list;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        score_list = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            list[i] = new ArrayList<>();
            score_list[i] = new ArrayList<>();
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1){
                break;
            }

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            bfs(i);
        }

        System.out.println(score+" "+score_list[score].size());
        score_list[score].sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i = 0; i<score_list[score].size(); i++){
            System.out.print(score_list[score].get(i)+ " ");
        }

    }

    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(new int[]{start, 0}); //회원, 점수
        int cur_score = 0;
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i<list[cur[0]].size(); i++){
                if(!visited[list[cur[0]].get(i)]){
                    visited[list[cur[0]].get(i)] = true;
                    q.add(new int[]{list[cur[0]].get(i), cur[1]+1});
                }
            }
            cur_score = cur[1];
        }
        if(cur_score < score){
            score = cur_score;
            count = 1;
        } else if (cur_score == score){
            count++;
        }
        score_list[cur_score].add(start);
    }
}