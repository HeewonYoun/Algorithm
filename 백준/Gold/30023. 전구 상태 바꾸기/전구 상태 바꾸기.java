import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[] lights;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //전구 개수
        lights = br.readLine().toCharArray();

        //R->G->B->R
        //전구 상태 바꾸는 과정 최소 몇번인지, 못하면 -1
        int result = Integer.MAX_VALUE / 2;

        //3가지 경우
        for(int i = 0; i<3; i++){
            result = Math.min(result, solve(lights) + i); //Integer.MAX_VALUE에서 +i하면 넘어감...;;
            changeLight(0, lights); //첫번째 전구 변경
        }

        if(result == Integer.MAX_VALUE / 2){
            System.out.println(-1);
        } else System.out.println(result);

    }

    static int solve(char[] lights){//첫번째 전구를 기준으로 나머지 전구 동일한 색 맞추기
        char[] newArr = Arrays.copyOf(lights, N);
        int count = 0;

        //첫번째 전구 기준으로 1~(n-) 전구까지 처리
        for(int i = 1; i<=N-3; i++){
            while(newArr[0] != newArr[i]){
                count++;
                changeLight(i, newArr);
            }
        }

        //전구 통일 여부 확인
        for(int i = 1; i<N; i++){
            if(newArr[0] != newArr[i]){
                return Integer.MAX_VALUE / 2;
            }
        }
        return count;
    }

    static void changeLight(int idx, char[] arr){
        for(int i = idx; i< idx+3; i++){
            arr[i] = changeColor(arr[i]);
        }
    }

    static char changeColor(char c){
        if(c == 'R'){
            return 'G';
        } else if ( c == 'G'){
            return 'B';
        } else return 'R';
    }
}