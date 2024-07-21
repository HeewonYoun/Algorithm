import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N + 1];
        int[] result = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(N);

        for (int i = N - 1; i > 0; i--) {
            while(!stack.isEmpty()){
                if (top[stack.peek()] <= top[i]) {
                    int idx = stack.pop();
                    result[idx] = i;
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            result[idx] = 0;
        }

        for(int i = 1; i<= N; i++){
            System.out.print(result[i] + " ");
        }
    }
}