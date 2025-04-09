import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] list;
    static int[] wSum; //누적 칭찬 받은 정도

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); //직원 수
        M = Integer.parseInt(st.nextToken()); //최초의 칭찬 횟수

        list = new ArrayList[N+1]; //직원 번호 1번부터
        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){ //직원  N명의 직속 상사 번호
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp != -1) list[tmp].add(i); //사장인 경우 제외
        }
        
        wSum = new int[N+1];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); //칭찬받은 직원 번호
            int w = Integer.parseInt(st.nextToken()); //칭찬 수치

            wSum[num] += w;
        }

        dfs(1);
        for(int i = 1; i<=N; i++){
            sb.append(wSum[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int index){
        for(int next: list[index]){
            wSum[next] += wSum[index];
            dfs(next);
        }
    }
}
