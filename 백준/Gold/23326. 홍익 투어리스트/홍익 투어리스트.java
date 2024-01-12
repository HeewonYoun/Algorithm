import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken()); // 구역 개수
        int Q = Integer.parseInt(st.nextToken()); // 쿼리 개수

        TreeSet<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i < N + 1; i++) {
            int check = Integer.parseInt(st.nextToken());
            if (check == 1) {
                set.add(i);
            }
        }

        StringBuffer sb = new StringBuffer();
        int cur = 1; // 도현 현재 위치
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int query = Integer.parseInt(st.nextToken());

            if (query == 1) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }

            } else if (query == 2) { // 도현 이동
                int num = Integer.parseInt(st.nextToken());
                cur = (num + cur) % N;
                if(cur == 0) cur = N;

            } else if (query == 3) {
                if(set.isEmpty()){
                    sb.append(-1 + "\n");
                    continue;
                }
                if(set.contains(cur)){
                    sb.append(0 + "\n"); //현재 위치
                    continue;
                }

                Integer front = set.higher(cur);
                Integer back = set.higher(0); //0 바로 아래 있는 객체 찾기

                if(front != null){
                    sb.append(front - cur + "\n");
                } else {
                    sb.append(N - cur + back +"\n");
                }
            }
        }
        System.out.println(sb);
    }
}