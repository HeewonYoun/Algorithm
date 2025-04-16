import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek() > y){ //stack에 더 높은거 있는 경우 (높이 낮아진 경우)
                result++; //추가
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek() == y) continue; //현재 높이랑 같은 경우 continue

            stack.push(y); //현재 높이 스택에 추가
        }

        while(!stack.isEmpty()){ //남은 건물 있는 경우
            if(stack.peek() > 0) result++;
            stack.pop();
        }

        System.out.println(result);
    }
}
