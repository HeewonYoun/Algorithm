import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs("");
    }

    static void dfs(String str){

        if(str.length() == N){
            System.out.println(str);
            System.exit(0);
        }

        for(int i = 1; i<=3; i++){
            if(check(str + i)){
                dfs(str + i);
            }
        }
    }

    static boolean check(String str){ //인접한 두 개의 부분수열이 동일한 것이 없어야 함

        for(int i = 1; i <= str.length() / 2; i++){
            String left = str.substring(str.length() - 2 * i, str.length() - i);
            String right = str.substring(str.length() - i, str.length());

            if (left.equals(right)) return false;
        }

        return true;
    }
}