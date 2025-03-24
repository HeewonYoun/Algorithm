import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static int[] arr = {9,8,7,6,5,4,3,2,1,0};
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dfs(0, 0);
        Collections.sort(list);

        if(N > list.size()){
            System.out.println(-1);
        } else {
            System.out.println(list.get(N-1));
        }

    }

    static void dfs(int index, long num){
        if(!list.contains(num)){
            list.add(num);
        }

        if(index >= 10) return;

        dfs(index + 1, (num*10)+arr[index]);
        dfs(index + 1, num);
    }
}
