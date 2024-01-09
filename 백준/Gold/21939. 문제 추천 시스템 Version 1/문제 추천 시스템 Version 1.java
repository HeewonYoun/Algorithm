import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<int[]> pqMin;
    static PriorityQueue<int[]> pqMax;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        //쉬운 문제 - 번호 작은순으로 출력
        //어려운 문제 여러개 - 문제 번호 큰 순으로 출력
        pqMin = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        pqMax = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });
        map = new HashMap<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine().trim());
            int P = Integer.parseInt(st.nextToken()); //문제번호
            int L = Integer.parseInt(st.nextToken()); //난이도

            pqMin.offer(new int[]{P, L});
            pqMax.offer(new int[]{P, L});
            map.put(P, L);
        }

        //명령문
        StringBuffer sb = new StringBuffer();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine().trim());
            String statement = st.nextToken();

            switch(statement){
                case "recommend":
                    int num = Integer.parseInt(st.nextToken());

                    if(num == 1){ //가장 어려운 문제 번호 출력
                        int ans = check(pqMax);
                        if(ans == 0) break;
                        
                        sb.append(ans + "\n");
                    } else { //가장 쉬운 문제 번호 출력
                        int ans = check(pqMin);
                        if(ans == 0) break;
                        
                        sb.append(ans + "\n");
                    }
                    break;

                case "add":
                    int P = Integer.parseInt(st.nextToken()); //문제번호
                    int L = Integer.parseInt(st.nextToken()); //난이도

                    pqMin.offer(new int[]{P, L});
                    pqMax.offer(new int[]{P, L});
                    map.put(P, L);
                    break;
                    
                case "solved":
                    int solved = Integer.parseInt(st.nextToken());
                    map.remove(solved);
                    break;
            }
        }
        System.out.println(sb);
    }

    static int check(PriorityQueue<int[]> q){ //큐에 들어있는게 실제 있는 문제인지 체크
        if(!q.isEmpty()) {
            int[] tmp = q.peek();
            if(map.containsKey(tmp[0]) && map.get(tmp[0]) == tmp[1]){ //있는 문제면
                return tmp[0];
            } else { //없는 문제면
            	q.poll();
                return check(q);
            }
        }
		return 0;
    }
}