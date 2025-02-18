import java.io.*;
import java.util.*;

public class Main {

    static int N, K, P, X;
    static int[][] arr = { //각 수마다 다른 수로 바꿀 때 반전이 필요한 횟수
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //1~N층까지 이용 가능
        K = Integer.parseInt(st.nextToken()); //디스플레이에 K자리의 수 보임
        P = Integer.parseInt(st.nextToken()); //최대 반전 횟수
        X = Integer.parseInt(st.nextToken()); //현재 멈춰있는 층

        solution(0, 1, 0, 0);
        System.out.println(result -1);
    }

    /**
     * @param index  현재 자리수 (0~K)
     * @param num    현재 자리의 자릿값 (1, 10, 100, ...)
     * @param cur    현재까지 만들어진 숫자
     * @param count  현재까지 반전된 LED 개수
     */
    static void solution(int index, int num, int cur, int count){
        if(cur > N || count > P) return; //현재 층이 범위를 벗어나거나 반전 횟수를 초과하면

        if(index == K){ //K자리 숫자 모두 정한 경우
            if(cur != 0) result++;
            return;
        }

        for(int i = 0; i<10; i++){
            //현재 자리수를 i로 변경한 경우
            solution(index + 1, num * 10, i*num+cur, count + arr[X/num%10][i]); //X/num%10: 현재 자리의 숫자
        }
    }
}