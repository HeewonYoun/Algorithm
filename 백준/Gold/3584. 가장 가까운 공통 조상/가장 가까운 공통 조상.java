import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            N = Integer.parseInt(br.readLine()); //노드 수

            parent = new int[N+1];
            visited = new boolean[N+1];

            for(int i = 1; i<N; i++){ //간선 정보
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()); //부모
                int B = Integer.parseInt(st.nextToken()); //자식

                parent[B] = A;
            }

            //가까운 공통 조상을 구할 두 노드
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            check(A,B);
        }
    }

    static void check(int A, int B){
        while(A > 0){ //A를 루트 노드까지 이동
            visited[A] = true;
            A = parent[A];
        }

        while(B > 0){
            if(visited[B]){
                System.out.println(B);
                break;
            }
            B = parent[B];
        }
    }
}