import java.io.*;
import java.util.*;

public class Main {

    static int N,K;
    static int[] score;
    static int total;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //시험지 개수
        K = Integer.parseInt(st.nextToken()); //나눌 그룹의 수

        score = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i<N; i++){
            score[i] = Integer.parseInt(st.nextToken());
            total += score[i];
        }

        //이분탐색
        int left = 0; //최소 점수
        int right = total; //최대 점수

        while(left <= right){
            int mid = (left + right) /2;
            int sum = 0;
            int count = 0; //그룹 개수

            for(int i = 0; i<N; i++){
                sum += score[i];

                if(sum >= mid){
                    count++;
                    sum = 0;
                }
            }

            if(count >= K) left = mid + 1; //그룹 개수 K 이상이면 더 높은 점수 만들 수 O
            else right = mid -1;
        }

        System.out.println(right);
    }
}
