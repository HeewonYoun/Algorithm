import java.io.*;
import java.util.*;

public class Main {

    static int[][] A;
    static int[][] calc, tmpl;
    static int[] seq; // 연산 순서 담을 배열
    static boolean[] isSel;
    static int K, N, M;
    static int min; // 배열 A의 최솟값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 회전 연산의 개수

        A = new int[N+1][M+1]; // 배열
        calc = new int[K][3]; // 회전 연산 순서 담을 배열 {r,c,s}
        min = Integer.MAX_VALUE;
        seq = new int[K];
        isSel = new boolean[K];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            // 회전 연산의 정보 다 받기
            st = new StringTokenizer(br.readLine());
            calc[i][0] = Integer.parseInt(st.nextToken());
            calc[i][1] = Integer.parseInt(st.nextToken());
            calc[i][2] = Integer.parseInt(st.nextToken());
        }

        c(0);
        System.out.println(min);

    }

    static void c(int cnt) {
        if (cnt == K) { // 회전 연산 순서는 임의로 정해도 된다 -> 순열 kPk
//            System.out.println(Arrays.toString(seq));
            // 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)인 정사각형 시계방향으로 돌리기
            
            tmpl = new int[N+1][M+1];
            //배열 복사
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < M+1; k++) {
                    tmpl[j][k] = A[j][k];
                }
            }
        	         
            for (int i = 0; i < K; i++) {

                int sx = calc[seq[i]][0] - calc[seq[i]][2];
                int sy = calc[seq[i]][1] - calc[seq[i]][2];
                int dx = calc[seq[i]][0] + calc[seq[i]][2];
                int dy = calc[seq[i]][1] + calc[seq[i]][2];

                while (true) {
//                    System.out.println("시작: "+sx+" "+sy+"도착:"+dx+" "+dy);
                    int checkx = dx - sx;
                    int checky = dy - sy;

                    if (sx == dx && sy == dy) {
                        break;
                    }
                    
                    //왼쪽첫번째 저장
                    int f = tmpl[sx][sy];
                    
                    for (int j = 0; j < checkx; j++) { // 상으로 한칸
//                      System.out.println(A[sx][sy]);
                      tmpl[sx][sy] = tmpl[sx+1][sy];
                      sx += 1;
                  }
//                  System.out.println("================");
                    
                    for (int j = 0; j < checky; j++) { // 좌로 한칸
//                      System.out.println(A[sx][sy]);
                      tmpl[sx][sy] = tmpl[sx][sy+1];
                      sy += 1;
                  }
//                  System.out.println("================");
                    
                    for (int j = 0; j < checkx; j++) { // 하로 한칸
//                      System.out.println(A[sx][sy]);
                      tmpl[sx][sy] = tmpl[sx-1][sy];
                      sx -= 1;
                      
                  }
//                  System.out.println("================");
                    
                    for (int j = 0; j < checky-1; j++) { // 우로 한칸
//                        System.out.println(A[sx][sy]);
                        tmpl[sx][sy] = tmpl[sx][sy-1];
                        sy -= 1;
                    }
//                    System.out.println("================");
                    
                    //제일 첫번째 넣기
                    tmpl[sx][sy] = f;
                    sy -= 1;

                    
                    sx = sx + 1;
                    sy = sy + 1;
                    dx = dx - 1;
                    dy = dy - 1;
                    
                }

//                for(int j = 1; j<N+1; j++) {
//                    System.out.println(Arrays.toString(tmpl[j]));
//                }
//                System.out.println();

            }
            
            // 배열 A의 최솟값 구하기
            int sum[] = new int[N+1];
            for(int i=1; i<N+1;i++) {
                for(int j =1; j<M+1; j++) {
                    sum[i] += tmpl[i][j];
                }
                if(sum[i]<min) {
                    min = sum[i];
                }
            }

            return;
        }
        for (int i = 0; i < K; i++) {
            if (isSel[i])
                continue;

            seq[cnt] = i;
            isSel[i] = true;
            c(cnt + 1);
            isSel[i] = false;
        }
    }
}