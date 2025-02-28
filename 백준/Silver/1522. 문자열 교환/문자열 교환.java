import java.io.*;

public class Main {

    static char[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = br.readLine().toCharArray();

        int result = Integer.MAX_VALUE;
        int cntA = 0;
        for(int i = 0; i<list.length; i++){ //A 개수 세기
            if(list[i] == 'a') cntA++;
        }

        for(int i = 0; i<list.length; i++){
            int cntB = 0;
            for(int j = i; j<i+cntA; j++){
                int index = j % list.length;
                if(list[index] == 'b') cntB++;
            }
            result = Math.min(result, cntB);
        }

        System.out.println(result);
    }
}