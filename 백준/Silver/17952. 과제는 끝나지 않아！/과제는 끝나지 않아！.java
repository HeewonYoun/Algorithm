import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //이번학기 몇 분인지
        Stack<int[]> task = new Stack<>();
        int result = 0;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if(num == 1){
                int A = Integer.parseInt(st.nextToken()); //과제 만점
                int T = Integer.parseInt(st.nextToken()); //걸리는 시간

                if(T == 1){
                    result += A;
                } else {
                    task.add(new int[]{A, T-1});
                }

            } else if(num == 0 && !task.isEmpty()){
                int[] cur = task.pop();

                if(cur[1] == 1) {
                    cur[1] = 0;
                    result += cur[0];

                } else {
                    task.add(new int[]{cur[0], cur[1]-1});
                }
            }
        }
        System.out.println(result);

    }
}