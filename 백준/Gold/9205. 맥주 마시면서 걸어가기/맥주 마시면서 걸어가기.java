import java.io.*;
import java.util.*;

public class Main {

    static int n,sx,sy,dx,dy;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++) {
            n = Integer.parseInt(br.readLine()); //맥주 파는 편의점 개수
            List<int[]> list = new ArrayList<>();

            for(int i=0; i<n+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(i==0) { //시작점
                    sx = x;
                    sy = y;

                }else if(i==n+1) { //도착점
                    dx = x;
                    dy = y;

                }else { //편의점 좌표
                    list.add(new int[]{x,y});
                }
            }

            sb.append(bfs(list)? "happy\n" : "sad\n");
        }

        System.out.println(sb);
    }

    static boolean bfs(List<int[]> list) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new int[] {sx,sy});

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];

            //현재 위치에서 도착점까지 거리 확인
            if(Math.abs(px-dx) + Math.abs(py-dy) <= 1000) return true;

            for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    int nx = list.get(i)[0], ny = list.get(i)[1];
                    int dist = Math.abs(px - nx) + Math.abs(py - ny);

                    if(dist <= 1000) { //맥주 20병 이내로 이동 가능한 경우
                        visited[i] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return false;
    }
}
