import java.io.*;
import java.util.*;

public class Main {

    static int C, P;
    static int[][][] block = {
            {{0}, {0,0,0,0}},
            {{0,0}}, 
            {{0,0,1}, {1,0}}, 
            {{1,0,0},{0,1}},
            {{0,0,0},{0,1},{1,0,1},{1,0}},
            {{0,0,0},{0,0},{0,1,1},{2,0}},
            {{0,0,0},{0,0},{1,1,0},{0,2}}
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken()); //열 수
        P = Integer.parseInt(st.nextToken())-1; //떨어뜨리는 블록 번호

        int[] map = new int[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<C; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 0; i<block[P].length; i++){ //선택한 블록의 모든 회전형태 확인
            for(int j = 0; j<C-block[P][i].length + 1; j++){ //블록이 놓일 수 있는 위치 탐색
                int diff = map[j] - block[P][i][0];
                boolean check = true;

                for(int k = 1; k<block[P][i].length; k++){
                    if(diff != map[j+k] - block[P][i][k]){
                        check = false;
                        break;
                    }
                }

                if(check) result++;
            }
        }

        System.out.println(result);
    }
}