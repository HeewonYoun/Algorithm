import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //에라토스테네스의 체 - 소수 판별
        boolean[] prime = new boolean[10000];
        prime[0] = prime[1] = true;

        for(int i = 2; i<10000; i++){
            if(!prime[i]) {
                for(int j = i + i; j<10000; j += i){
                    prime[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            int[] count = new int[10000]; //변경 횟수
            int[] d = {1000, 100, 10, 1};

            q.add(start);
            visited[start] = true;

            while(!q.isEmpty()){
                int cur = q.poll();

                if(cur == end) {
                    System.out.println(count[end]);
                    break;
                }

                for(int i = 0; i<4; i++){
                    int val = cur / d[i] / 10; //바뀔 숫자
                    int mod = cur % d[i]; //나머지

                    for(int j = 0; j<= 9; j++){
                        if(i == 0 && j == 0) continue; //천의자리

                        int next = (val * d[i] * 10) + (j * d[i]) + mod;

                        if(!visited[next] && !prime[next]){
                            q.offer(next);
                            visited[next] = true;
                            count[next] = count[cur] + 1;
                        }
                    }
                }
            }

            if(!visited[end]){
                System.out.println("Impossible");
            }

        }
    }
}