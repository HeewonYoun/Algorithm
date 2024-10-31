import java.io.*;
import java.util.*;

public class Main {

    static int N, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //지름길 개수
        D = Integer.parseInt(st.nextToken()); //고속도로 길이

        List<int[]> shortcut = new ArrayList<>();

        for(int i = 0; i<N; i++){ //지름길 시작위치, 도착위치, 지름길 길이
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //시작위치
            int e = Integer.parseInt(st.nextToken()); //도착위치
            int l = Integer.parseInt(st.nextToken()); //지름길 길이

            if(e > D) continue; //고속도로 길이 넘으면 continue
            if(e-s > l){ //최단거리일 경우 add
                shortcut.add(new int[]{s, e, l});
            }
        }

        shortcut.sort(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){ //시작 지점 같으면 종료 지점 기준 오름차순
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] dist = new int[D+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        int next = 0;
        int idx = 0;

        while(next < D){
            if(idx < shortcut.size()){
                int[] cur = shortcut.get(idx);
                if(next == cur[0]) { //시작 지점이랑 같으면
                    dist[cur[1]] = Math.min(dist[next] + cur[2], dist[cur[1]]); //거리더한값, 지름길 비교
                    idx++;
                } else {
                    dist[next + 1] = Math.min(dist[next + 1], dist[next] + 1);
                    next++;
                }

            } else {
                dist[next + 1] = Math.min(dist[next + 1], dist[next] + 1);
                next++;
            }
        }
        System.out.println(dist[D]);
    }
}