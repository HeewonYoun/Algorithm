import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static String str;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        visited = new boolean[str.length()];

        zoac(0, str.length()-1);

        System.out.println(sb);
    }

    static void zoac(int left, int right){
        if(left > right) return; //범위 잘못된 경우

        // 현재 구간에서 가장 앞선 문자의 인덱스 찾기
        int index = left;
        for(int i = left; i<=right; i++){
            if(str.charAt(index) > str.charAt(i)){
                index = i;
            }
        }

        visited[index] = true;

        for(int i = 0; i<str.length(); i++){
            if(visited[i]){
                sb.append(str.charAt(i));
            }
        }
        sb.append('\n');

        zoac(index+1, right); //오른쪽 탐색
        zoac(left, index-1); //왼쪽 탐색
    }
}
