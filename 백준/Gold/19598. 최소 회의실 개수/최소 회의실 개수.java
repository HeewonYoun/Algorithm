import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2) { //회의 시작 기준 오름차순
                if (o1[0] == o2[0])
                    return o1[1] - o2[1]; //종료 시간 오름차순
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new int[] {start, end});
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(queue.poll()[1]);

        while (!queue.isEmpty()) {
            int time[] = queue.poll();
            if (pq.peek() <= time[0]) {
                pq.poll();
            }
            pq.add(time[1]);
        }
        System.out.println(pq.size());
    }

}
