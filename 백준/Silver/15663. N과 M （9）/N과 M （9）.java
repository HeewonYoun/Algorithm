import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] num;
    static int[] select;
    static boolean[] visited;
    static LinkedHashSet<String> result = new LinkedHashSet<>(); //삽입 순서 유지됨

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N개의 자연수 중 M개를 고른 수열
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        select = new int[M];

        num = new int[N];

        //길이 M인 수열, 중복 X
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); //오름차순 정렬
        p(0);

        Iterator<String> iter = result.iterator();
        while(iter.hasNext()){
            sb.append(iter.next());
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void p(int count){
        if(count == M){
            //결과를 set에 넣어서 중복 방지
            StringBuilder sb1 = new StringBuilder();
            for(int i = 0; i<M; i++){
                sb1.append(select[i]).append(" ");
            }
            result.add(sb1.toString());
            return;
        }

        for(int i = 0; i<N; i++){
            if(visited[i]) continue;

            visited[i] = true;
            select[count] = num[i];
            p(count + 1);

            visited[i] = false;
        }
    }
}