import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //배열 크기
        M = Integer.parseInt(st.nextToken()); //구간

        arr = new int[N];

        int left = 0;
        int right = -1;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]); //최댓값으로 right 갱신
        }

        while(left < right){
            int mid = (left + right) / 2; //각 구간에서 최대값-최소값이 가질 수 있는 최대 허용값

            if(solve(mid) <= M) right = mid; //mid를 기준으로 나눈 구간의 개수가 M 이하라면 mid 값을 줄여서 탐색
            else left = mid + 1;
        }

        System.out.println(right);
    }

    static int solve(int mid){
        int count = 1;
        int min = arr[0];
        int max = arr[0];

        for(int i = 1; i< arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if((max - min) > mid){ //구간의 최댓값-최솟값이 mid보다 크면 새로운 구간 시작
                min = arr[i];
                max = arr[i];
                count++; //구간 개수 증가
            }
        }
        return count;
    }

}