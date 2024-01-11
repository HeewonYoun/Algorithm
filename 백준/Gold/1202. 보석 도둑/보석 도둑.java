import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //보석 총 갯수
        int K = Integer.parseInt(st.nextToken()); //가방 갯수

        Map<Integer, Integer> bagmap = new HashMap<>();
        List<int[]> jewel = new ArrayList<>();
        PriorityQueue<Integer> bagpq = new PriorityQueue<>(); //가방 작은거부터 채우기

        for(int i = 0; i<N; i++){ //보석 정보 M(무게), V(가격)
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewel.add(new int[]{M,V});
        }
        
        Collections.sort(jewel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1]; //무게 같으면 가격 내림차순
                }
                return o1[0] - o2[0]; //무게 오름차순
            }
        });

        for(int i = 0; i<K; i++){ //가방에 담을 수 있는 최대 무게
            int C = Integer.parseInt(br.readLine().trim());

            bagmap.put(C, 0);
            bagpq.offer(C);
        }

        //훔칠 수 있는 보석 가격의 합의 최댓값 출력
        //특정 가방의 무게보다 작은 보석의 가격을 모두 우선순위 큐에 넣기
        //가격 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        long max = 0;
        int j = 0;
        for(int i = 0; i<K; i++){
            int bag = bagpq.poll();

            while(j < N && jewel.get(j)[0] <= bag) {
            	pq.offer(jewel.get(j++)[1]);
            }
            if(!pq.isEmpty()) {
            	max += pq.poll();
            }
        }
        System.out.println(max);
    }
}