import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //책의 개수
        M = Integer.parseInt(st.nextToken()); //한 번에 들 수 있는 책의 개수

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); //내림차순 정렬
        PriorityQueue<Integer> nq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        int maxdir = 0;
        for(int i = 0; i<N; i++){
            int dir = Integer.parseInt(st.nextToken());
            if(dir < 0){
                nq.add(dir);
            } else pq.add(dir);

            if(Math.abs(dir) > maxdir) maxdir = Math.abs(dir);
        }

        //책을 제자리에 놔둘 때 드는 최소 걸음 수 계산
        int result = 0;

        while(!nq.isEmpty()){
            int cur = nq.poll();

            for(int i = 0; i < M-1; i++ ){
                nq.poll();

                if(nq.isEmpty()){
                    break;
                }
            }

            result += Math.abs(cur) * 2;
        }

        while(!pq.isEmpty()){
            int cur = pq.poll();

            for(int i = 0; i < M-1; i++ ){
                pq.poll();

                if(pq.isEmpty()){
                    break;
                }
            }

            result += cur * 2;
        }

        result -= maxdir; //제일 마지막엔 안돌아와도 됨
        System.out.println(result);
    }
}