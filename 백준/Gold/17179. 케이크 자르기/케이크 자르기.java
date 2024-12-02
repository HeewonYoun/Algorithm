import java.io.*;
import java.util.*;

public class Main {

    static int N, M, L;
    static int[] spot;
    static int[] count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //자르는 횟수 담긴 목록 길이
        M = Integer.parseInt(st.nextToken()); //자를 수 있는 지점 개수
        L = Integer.parseInt(st.nextToken()); //롤 케이크 길이

        spot = new int[M+1]; //자를 수 있는 지점
        for(int i = 0; i<M; i++){
            spot[i] = Integer.parseInt(br.readLine());
        }
        spot[M] = L;

        count = new int[N]; //자르는 횟수
        for(int i = 0; i<N; i++){
            count[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++){
            int result = 0;

            int left = 0;
            int right = L;

            while(left <= right){
                int mid = (left + right) / 2; //최소 길이가 mid일 때 count만큼 자를 수 있는지 확인

                int cnt = 0;
                int last = 0; //마지막으로 자른 곳

                for(int j = 0; j<= M; j++){
                    if(spot[j] - last >= mid){
                        cnt++;
                        last = spot[j];
                    }

                    if(cnt > count[i]) break;
                }

                if(cnt > count[i]){
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}