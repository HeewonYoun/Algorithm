import java.io.*;
import java.util.*;

public class Main {

    static int H, W;
    static int[] height;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken()); //세로
        W = Integer.parseInt(st.nextToken()); //가로
        height = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<W; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0; //고이는 빗물의 총량
        for(int i = 1; i<W-1; i++){
            int left = 0;
            int right = 0;

            for(int j = 0; j<i; j++){ //현재 위치 기준 왼쪽 최대 높이 구하기
                left = Math.max(left, height[j]);
            }

            for(int j = i+1; j<W; j++){ //현재 위치 기준 오른쪽 최대 높이 구하기
                right = Math.max(right, height[j]);
            }

            if(height[i] < left && height[i] < right){
                result += Math.min(left, right) - height[i];
            }
        }

        System.out.println(result);
    }
}