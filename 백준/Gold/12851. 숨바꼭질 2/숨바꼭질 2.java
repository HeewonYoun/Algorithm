import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] time = new int[100001];
    static int[] dx = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //수빈 위치
        K = Integer.parseInt(st.nextToken()); //동생 위치

        //가장 빠른 시간, 방법 수 출력
        int minTime = Integer.MAX_VALUE;
        int count = 0;

        if(N == K){
            System.out.println(0);
            System.out.println(1);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        time[N] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(minTime < time[cur]) break;

            for(int i = 0; i<3; i++){
                int nx;

                if(i == 0) nx = cur + dx[i];
                else if(i == 1) nx = cur + dx[i];
                else nx = cur * dx[i];

                if(nx < 0 || nx > 100000) continue;
                if(nx == K){
                    minTime = time[cur];
                    count++;
                }

                if(time[nx] == 0 || time[nx] == time[cur] + 1){
                    q.offer(nx);
                    time[nx] = time[cur] + 1;
                }
            }
        }

        System.out.println(minTime);
        System.out.println(count);
    }
}