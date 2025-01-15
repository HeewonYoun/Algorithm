import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] lights;
    static int[] answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lights = new int[N];
        answer = new int[N];

        char[] tmp = br.readLine().toCharArray();
        char[] tmp2 = br.readLine().toCharArray();
        for(int i = 0; i<N; i++){
            lights[i] = tmp[i] - '0';
            answer[i] = tmp2[i] - '0';
        }

        int[] copy = Arrays.copyOf(lights, N);
        copy[0] = 1 - copy[0];
        copy[1] = 1 - copy[1];

        int result = solve(lights); //첫번째 전구 스위치 안누르는 경우
        int result2 = solve(copy); //첫번째 전구 스위치 누르는 경우

        if(result2 != -1) result2++;
        if(result == -1){
            System.out.println(result2);
        } else if(result2 == -1){
            System.out.println(result);
        } else {
            System.out.println(Math.min(result, result2));
        }
    }

    static int solve(int[] arr){
        int count = 0;

        for(int i = 0; i<N-1; i++){
            if(arr[i] != answer[i]){
                count++;

                arr[i] = 1 - arr[i];
                arr[i+1] = 1 - arr[i+1];

                if(i != N-2){
                    arr[i+2] = 1 - arr[i+2];
                }
            }
        }

        return arr[N-1] != answer[N-1] ? -1 : count;
    }
}