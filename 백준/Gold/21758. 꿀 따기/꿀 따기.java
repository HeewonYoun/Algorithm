import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] honey;

    static long[] leftSum;
    static long[] rightSum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        honey = new long[N];
        leftSum = new long[N]; //오른쪽 -> 왼쪽 누적합
        rightSum = new long[N]; //왼쪽 -> 오른쪽 누적합

        st = new StringTokenizer(br.readLine());
        long tmp = 0;
        for(int i = 0; i<N; i++){
            honey[i] = Integer.parseInt(st.nextToken());

            tmp += honey[i];
            rightSum[i] = tmp;
        }

        tmp = 0;
        for(int i = N-1; i>=0; i--){
            tmp += honey[i];
            leftSum[i] = tmp;
        }

        long result = 0; //가능한 최대의 꿀의 양

        //벌벌꿀통
        for(int i = 1; i<N-1; i++){
            long left = rightSum[N-1] - honey[0] - honey[i];
            long right = rightSum[N-1] - rightSum[i];

            result = Math.max(result, left + right);
        }

        //꿀통벌벌
        for (int i = 1; i < N - 1; i++) {
            long left = rightSum[N-1] -leftSum[i];
            long right = rightSum[N-1] - honey[N-1] - honey[i];

            result = Math.max(result, left+right);
        }

        //벌꿀통벌
        for(int i = 1; i<N-1; i++){
            long left = rightSum[i] - honey[0];
            long right = leftSum[i] - honey[N-1];

            result = Math.max(result, left + right);
        }


        System.out.println(result);
    }
}