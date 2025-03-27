import java.io.*;
import java.util.*;

public class Main{

    static int T;
    static char[] p; //수행할 함수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        TC: for(int tc = 0; tc<T; tc++){
            p = br.readLine().toCharArray(); //수행할 함수
            int n = Integer.parseInt(br.readLine()); //배열 크기
            Deque<Integer> deq = new LinkedList<>();

            st = new StringTokenizer(br.readLine(), "[,]");
            for(int i = 0; i<n; i++){ //배열에 들어있는 수 입력
                deq.offer(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;

            for(int i = 0; i<p.length; i++){
                if(p[i] == 'R'){
                    reverse = !reverse;
                } else {
                    if(deq.isEmpty()){ //dequeue에 아무것도 없을 경우
                        sb.append("error").append('\n');
                        continue TC;
                    }
                    if(!reverse) deq.pollFirst(); //정방향인 경우
                    else deq.pollLast(); //역방향인 경우
                }
            }

            sb.append("[");
            while(!deq.isEmpty()){
                if(!reverse) sb.append(deq.pollFirst());
                else sb.append(deq.pollLast());
                if(deq.size() != 0) sb.append(',');
            }
            sb.append("]").append('\n');
        }

        System.out.println(sb);
    }
}
