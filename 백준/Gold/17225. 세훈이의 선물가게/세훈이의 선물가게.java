import java.io.*;
import java.util.*;

public class Main {

    static class Present implements Comparable<Present>{

        int time;
        char color;

        public Present(int time, char color) {
            this.time = time;
            this.color = color;
        }

        @Override
        public int compareTo(Present o) {
            if(this.time == o.time) return this.color - o.color;
            return Integer.compare(this.time, o.time);
        }
    }

    static int A, B, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        A = Integer.parseInt(st.nextToken()); //상민이가 선물 하나 포장하는데 걸리는 시간
        B = Integer.parseInt(st.nextToken()); //지수가 선물 하나 포장하는데 걸리는 시간
        N = Integer.parseInt(st.nextToken()); //어제 세훈 가게 손님 수

        PriorityQueue<Present> pq = new PriorityQueue<>();
        int tmpA = 0;
        int tmpB = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); //주문 시각
            char c = st.nextToken().charAt(0); //포장지 색깔 B, R
            int m = Integer.parseInt(st.nextToken()); //주문한 선물 개수

            for (int j = 0; j < m; j++) {
                if(c == 'B'){ //상민이 포장하는 경우
                    if(tmpA >= t){
                        pq.add(new Present(tmpA, c));
                        tmpA += A;

                    } else {
                        pq.add(new Present(t, c));
                        tmpA = t + A;
                    }
                } else { //지수가 포장하는 경우
                    if(tmpB >= t){
                        pq.add(new Present(tmpB, c));
                        tmpB += B;

                    } else {
                        pq.add(new Present(t, c));
                        tmpB = t + B;
                    }
                }
            }
        }

        int count = 1; //선물 번호
        List<Integer> l1 = new ArrayList<>(); //상민이 포장한 선물 리스트
        List<Integer> l2 = new ArrayList<>(); //지수가 포장한 선물 리스트

        while(!pq.isEmpty()){
            Present present = pq.poll();
            if(present.color == 'B'){
                l1.add(count);
            }else{
                l2.add(count);
            }
            count++;
        }

        sb.append(l1.size()).append("\n");
        for (int i = 0; i < l1.size(); i++) {
            sb.append(l1.get(i)).append(" ");
        }
        sb.append("\n").append(l2.size()).append("\n");
        for (int i = 0; i < l2.size(); i++) {
            sb.append(l2.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}