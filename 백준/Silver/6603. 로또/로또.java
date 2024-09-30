import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            nums = new int[k];
            visited = new boolean[k];

            for(int i  = 0; i<k; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            //kC6 (6개 숫자 고르는 경우의수 사전순)
            select(0, 0);

            System.out.println();
        }
    }

    static void select(int start, int count){
        if(count == 6){
            for(int i = 0; i<k ;i++){
                if(visited[i]){
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for(int i = start; i<k; i++){
            visited[i] = true;
            select(i + 1, count + 1);

            visited[i] = false;
        }
    }
}