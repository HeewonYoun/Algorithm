import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        //알파벳 대문자를 0~9까지 숫자중 하나로 바꿔서 N개의 수 합 최대 구하기
        for(int i = 0; i<N; i++){
            char[] tmp = br.readLine().toCharArray();

            for(int j = 0; j<tmp.length; j++){
                alpha[tmp[j] - 'A'] += (int) Math.pow(10, tmp.length - 1 - j);
            }
        }

        Arrays.sort(alpha);

        int num = 9;
        int result = 0;

        for(int i = alpha.length-1; i>= 0; i--){
            if(alpha[i] == 0) continue;
            result += alpha[i] * num;

            num--;
        }

        System.out.println(result);
    }
}