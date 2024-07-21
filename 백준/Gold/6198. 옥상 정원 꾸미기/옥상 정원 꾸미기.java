import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        long sum = 0;

        for(int i = 0; i<N; i++){
            int height = Integer.parseInt(br.readLine());

            while(!s.isEmpty()){
                if(s.peek() <= height) {
                    s.pop();
                } else break;
            }

            sum += s.size();
            s.push(height);
        }

        System.out.println(sum);
    }
}