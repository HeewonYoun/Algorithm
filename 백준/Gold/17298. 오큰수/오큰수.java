import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        //오큰수 NGE(i): 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수 , 없는 경우 -1
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<N; i++){
            while(!stack.isEmpty() && num[stack.peek()] < num[i]){ //스택이 비어있지 않고, 스택에 들어있는 인덱스의 수보다 현재 수가 더 클 때
                num[stack.pop()] = num[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            num[stack.pop()] = -1;
        }

        for(int i = 0; i<N; i++){
            sb.append(num[i]).append(" ");
        }
        System.out.println(sb);
    }
}
