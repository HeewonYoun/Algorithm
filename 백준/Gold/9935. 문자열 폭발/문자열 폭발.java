import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<word.length(); i++){
            stack.push(word.charAt(i));

            if(stack.size() >= bomb.length()){
                boolean flag = true;

                for(int j = 0; j<bomb.length(); j++){
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for(int j = 0; j<bomb.length(); j++){
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            sb.append("FRULA");
        } else {
            for(char c : stack){
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
