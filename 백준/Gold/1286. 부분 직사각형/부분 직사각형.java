import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] rect;
    static long[][] rectNum;

    static long[] alpha = new long[26];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rect = new char[N*2][M*2];

        for(int i = 0; i<N; i++){ //*4 확장
            String tmp = br.readLine();

            for(int j = 0;j<M; j++){
                char c = tmp.charAt(j);

                rect[i][j] = c;
                rect[i+N][j] = c;
                rect[i][j+M] = c;
                rect[i+N][j+M] = c;
            }
        }

        rectNum = new long[N*2][M*2];
        for(int i = 0; i<N*2; i++){ //(i,j)에서 해당 문자가 포함되는 모든 부분직사각형의 개수 계산
            for(int j = 0; j<M*2; j++){
                rectNum[i][j] = (long) (i+1) * (j+1) * (N*2L -i) * (M*2L -j);
            }
        }

        for(int i = 0; i<N*2; i++){
            for(int j = 0; j<M*2; j++){
                alpha[rect[i][j] - 'A'] += rectNum[i][j];
            }
        }

        for(long num : alpha){
            sb.append(num).append('\n');
        }

        System.out.println(sb);
    }
}
