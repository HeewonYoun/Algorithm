import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());

        for(int tc = 0; tc < T; tc++){
            PriorityQueue<Long> pq = new PriorityQueue<>(); //오름차순

            int K = Integer.parseInt(br.readLine().trim()); // 3<= K <= 1,000,000

            st = new StringTokenizer(br.readLine().trim());
            for(int i = 0; i<K; i++){
                long tmp = Integer.parseInt(st.nextToken());
                pq.offer(tmp);
            }

            long total = 0;
            long A = 0;
            long B = 0;

            while(!pq.isEmpty()){
                if(pq.size() == 1){
                    System.out.println(total);
                    break;
                }
                A = pq.poll();
                B = pq.poll();

                long tmp = A + B;
                total += tmp;

                pq.offer(tmp);
            }
        }
    }
}