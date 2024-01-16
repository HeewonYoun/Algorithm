import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine().trim());

            if(tmp == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                } else {
                    int min = pq.poll();
                    sb.append(min).append("\n");
                    continue;
                }
            }
            pq.offer(tmp);
        }
        System.out.println(sb);
    }
}