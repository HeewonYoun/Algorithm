import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[R][C];
        for(int i = 0; i<R; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j<C; j++){
                alpha[i][j] = tmp[j];
            }
        }

        int result = 0;

        int left = 0;
        int right = R-1;

        while(left <= right){
            int mid = (left + right)/2;

            if(check(mid)){
                result = mid;
                left = mid + 1; //더 많은 행 지울 수 있는지
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean check(int start){ //문자열 중복되지 않는지 확인
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i<C; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = start; j<R; j++){
                sb.append(alpha[j][i]);
            }

            String colString = sb.toString();

            if(!set.add(colString)){
                return false; //중복 있는 경우
            }
        }

        return true;
    }
}