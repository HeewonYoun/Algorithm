import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] operator = new int[4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i= 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i= 0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);

        //최댓값, 최솟값 출력
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int num, int index){
        if(index == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i<4; i++){
            if(operator[i] > 0){
                operator[i]--;

                switch(i) {
                    case 0: // +
                        dfs(num + nums[index], index + 1);
                        break;
                    case 1: // -
                        dfs(num - nums[index], index + 1);
                        break;
                    case 2: // *
                        dfs(num * nums[index], index + 1);
                        break;
                    case 3: // /
                        dfs(num / nums[index], index + 1);
                        break;
                }

                operator[i]++; //원상복구
            }
        }
    }
}