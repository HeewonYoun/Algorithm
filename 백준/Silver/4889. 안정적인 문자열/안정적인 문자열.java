import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = 0;

        while(true){
            TC++;
            char[] tmp = br.readLine().toCharArray();
            if(tmp[0] == '-') break;

            int result = 0; //문자열을 안정적으로 바꾸는데 필요한 최소 연산의 수 출력
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i<tmp.length; i++){
                if(tmp[i] == '{'){
                    stack.add(tmp[i]);
                } else if(tmp[i] == '}'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    } else {
                        stack.add('{');
                        result++;
                    }
                }
            }
            if(stack.size() == 1){
                result++;
            } else {
                result += stack.size() /2;
            }

            System.out.println(TC +". "+result);
        }

    }
}