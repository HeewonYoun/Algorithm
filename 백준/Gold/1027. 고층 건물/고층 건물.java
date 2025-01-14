import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] height;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //빌딩수
        height = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int i= 0; i<N; i++){
            double degree = 1_000_000_000;
            int count = 0;

            //기울기 = y증가량 / x증가량
            //왼쪽
            for(int j = i-1; j>= 0 ; j--){
                double tmp = (double) (height[j] - height[i]) / (j-i);

                if(degree > tmp){
                    degree = tmp;
                    count++;
                }
            }

            //오른쪽
            degree = -1_000_000_000;
            for(int j = i+1; j < N; j++){
                double tmp = (double) (height[j] - height[i]) / (j-i);

                if(degree < tmp){
                    degree = tmp;
                    count++;
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}