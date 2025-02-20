import java.io.*;
import java.util.*;

public class Main {

    static int S;
    static boolean[][] visited = new boolean[1001][1001]; //화면, 클립보드

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0}); //현재 이모티콘 수, 클립보드 이모티콘 수, 연산 횟수
        visited[1][0] = true; //화면, 클립보드

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int copy = cur[1];
            int count = cur[2];

            if(now == S){
                System.out.println(count);
                return;
            }

            //1번 연산 - 클립보드 복사
            q.offer(new int[]{now, now, count + 1});

            //2번 연산 - 붙여넣기
            if(copy > 0 && now + copy <= S && !visited[now+copy][copy]){
                q.offer(new int[]{now + copy, copy, count + 1});
                visited[now+copy][copy] = true;
            }

            //3번 연산 - 지우기
            if(now > 0 && !visited[now-1][copy]){
                q.offer(new int[]{now - 1, copy, count + 1});
                visited[now -1][copy] = true;
            }
        }
    }
}