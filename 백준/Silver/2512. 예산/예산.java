import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] area = new int[N];
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<N; i++){
            area[i] = Integer.parseInt(st.nextToken());
            sum += area[i];
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(area);

        //배정된 예산 중 최댓값 출력
        if(sum <= M){
            System.out.println(area[N-1]);
            return;
        }

        int left = 1;
        int right = area[N-1];
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int total = 0;

            for(int req : area){
                if(req < mid){
                    total += req;
                } else {
                    total += mid;
                }
            }

            if(total > M){
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);

    }
}