import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); //숫자카드 묶음 크기 개수 1<= N <= 100,000

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //오름차순

        for(int i = 0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine().trim());
            pq.offer(tmp);
        }
        
        if(pq.size() == 1){
            System.out.println(0);
            return;
        }

        int A;
        int B;
        int sum = 0;
        int total = 0;

        while(!pq.isEmpty()){
        	if(pq.size() == 1) { //pq에 하나 남았을 때 -> 정답
        		System.out.println(total);
        		return;
        	}
        	
        	A = pq.poll();
        	B = pq.poll();
        	
        	sum = A + B;
        	pq.offer(sum);
        	
        	total += sum;
        }
    }
}