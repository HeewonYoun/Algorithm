import java.io.*;
import java.util.*;

public class Main {

    static int G;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine()); // G = (현재 몸무게)^2-(기억하고 있던 몸무게)^2
        
        List<Integer> weight = new ArrayList<>();
        int m = 1; //기억하고 있던 몸무게
        int n = 2; //현재 몸무게

        while(m<100000){
            int g = (int) (Math.pow(n, 2) - Math.pow(m, 2));

            if(g == G){
                weight.add(n);
            }

            if(g < G) n++;
            else m++;
        }

        if(weight.size() == 0){
            System.out.println(-1);
        } else {
            Collections.sort(weight);
            for(int result : weight){
                System.out.println(result);
            }
        }
    }
}