import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        StringBuffer sb = new StringBuffer();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(); //오름차순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); //내림차순

        for(int i = 0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine().trim());

            if(pq1.size() == pq2.size()){
                pq2.offer(tmp);
            }else{
                pq1.offer(tmp);
            }

            if(!pq1.isEmpty() && !pq2.isEmpty()){
                if(pq1.peek() < pq2.peek()){
                    int tmp2 = pq1.poll();
                    pq1.offer(pq2.poll());
                    pq2.offer(tmp2);
                }
            }
            sb.append(pq2.peek()+"\n");
        }
        //중간값 외쳐야 함
        System.out.println(sb);
    }
}