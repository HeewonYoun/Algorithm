import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static char[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken()); //행
        N = Integer.parseInt(st.nextToken()); //열
        K = Integer.parseInt(br.readLine()); //조사 대상 영역 개수

        map = new char[M+1][N+1];

        int [][] jSum = new int[M+1][N+1]; //누적합 배열
        int [][] oSum = new int[M+1][N+1];
        int [][] iSum = new int[M+1][N+1];

        for(int i = 1; i<=M; i++){ //지도 내용 - 정글J, 바다O, 얼음I
            map[i] = br.readLine().toCharArray();

            for(int j = 1; j<=N; j++){
                jSum[i][j] = jSum[i-1][j] + jSum[i][j-1] - jSum[i-1][j-1];
                oSum[i][j] = oSum[i-1][j] + oSum[i][j-1] - oSum[i-1][j-1];
                iSum[i][j] = iSum[i-1][j] + iSum[i][j-1] - iSum[i-1][j-1];
                
                if(map[i][j-1] == 'J') jSum[i][j]++;
                else if(map[i][j-1] == 'O') oSum[i][j]++;
                else iSum[i][j]++;
            }
        }

        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //(a,b) ~ (c,d)
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int jcnt = jSum[c][d] - jSum[c][b-1] - jSum[a-1][d] + jSum[a-1][b-1]; //(c,d) - 왼쪽 - 위쪽 + 두번 뺀 부분 복구
            int ocnt = oSum[c][d] - oSum[c][b-1] - oSum[a-1][d] + oSum[a-1][b-1];
            int icnt = iSum[c][d] - iSum[c][b-1] - iSum[a-1][d] + iSum[a-1][b-1];

            sb.append(jcnt + " " + ocnt + " " + icnt + '\n');
        }

        System.out.println(sb);
    }
}
