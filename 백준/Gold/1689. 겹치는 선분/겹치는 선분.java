import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        List<int[]> spot = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            spot.add(new int[]{start, end});
        }

        spot.sort(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){ // 시작점 같으면 끝점 기준 오름차순
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]); //시작점 다른 경우 시작점 기준 오름차순
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] line : spot) {
            int start = line[0];
            int end = line[1];

            //겹치지 않는 선분 제거
            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.add(end); //끝점 추가

            max = Math.max(max, pq.size()); //최댓값 갱신
        }
        System.out.println(max);
    }
}