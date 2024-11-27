import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] height;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //연병장 크기
        M = Integer.parseInt(st.nextToken()); //조교 수

        height = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){ //연병장 각 칸의 높이
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[N+2]; //누적합..

        //조교의 지시: a~b칸까지 k만큼 흙을 덮거나 파내라고 지시
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            diff[a] += k;
            diff[b+1] -= k; //b 이후의 위치에 -k를 추가하여 그 이후부터 영향 제거
        }

        //diff 배열을 누적합으로
        for(int i = 1; i<=N; i++){
            diff[i] += diff[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            height[i] += diff[i];
            sb.append(height[i]).append(" ");
        }

        System.out.println(sb);
    }
}