import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Node> list = new ArrayList<>();

    static class Node implements Comparable<Node>{
        long x; //위치
        long a; //인원

        Node(long x, long a){
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Node o) {
            if(this.x == o.x){
                return Long.compare(this.a, o.a); //인원 수 기준 오름차순
            }

            return Long.compare(this.x, o.x); //거리 기준 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //마을 개수

        long sum = 0; //총 인원
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken()); //위치
            long a = Integer.parseInt(st.nextToken()); //인원

            list.add(new Node(x, a));
            sum += a;
        }

        Collections.sort(list);

        long result = 0;
        for(Node cur : list){
            result += cur.a;

            if((sum + 1)/2 <= result){ //전체 인구의 절반 이상이 되는 지점 찾기
                System.out.println(cur.x);
                return;
            }
        }
    }
}
