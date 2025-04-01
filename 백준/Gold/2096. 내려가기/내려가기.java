import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;

    static int[][] max;
    static int[][] min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][3];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        //얻을 수 있는 최대 점수, 최소 점수
        max = new int[N][3];
        min = new int[N][3];

        for(int i = 0; i<N; i++){
            if(i == 0){
                max[i][0] = min[i][0] = map[i][0];
                max[i][1] = min[i][1] = map[i][1];
                max[i][2] = min[i][2] = map[i][2];
            } else {
                max[i][0] += Math.max(max[i-1][0], max[i-1][1]) + map[i][0];
                max[i][1] += Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + map[i][1];
                max[i][2] += Math.max(max[i-1][1], max[i-1][2]) + map[i][2];

                min[i][0] += Math.min(min[i-1][0], min[i-1][1]) + map[i][0];
                min[i][1] += Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + map[i][1];
                min[i][2] += Math.min(min[i-1][1], min[i-1][2]) + map[i][2];
            }
        }

        int maxResult = Math.max(Math.max(max[N-1][0],max[N-1][1]),max[N-1][2]);
        int minResult = Math.min(Math.min(min[N-1][0],min[N-1][1]),min[N-1][2]);

        System.out.println(maxResult + " " + minResult);
    }
}
