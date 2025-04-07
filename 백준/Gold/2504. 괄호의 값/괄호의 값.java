import java.io.*;
import java.util.*;

public class Main {

    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int calc = 1;

        //() : 2, [] : 3
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
                calc *= 2;
                
            } else if (str.charAt(i) == ')'){
                if(stack.isEmpty() || stack.peek() != '('){ //잘못된 괄호일 때
                    result = 0;
                    break;
                } else if (str.charAt(i-1) == '('){
                    result += calc;
                }
                stack.pop();
                calc /= 2;
                
            } else if (str.charAt(i) == '['){
                stack.push(str.charAt(i));
                calc *= 3;
                
            } else if (str.charAt(i) == ']'){
                if(stack.isEmpty() || stack.peek() != '['){ //잘못된 괄호일 때
                    result = 0;
                    break;
                } else if (str.charAt(i-1) == '['){
                    result += calc;
                }
                stack.pop();
                calc /= 3;
            }
        }

        if(!stack.isEmpty()){
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
