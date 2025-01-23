import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] notebook;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로길이
        M = Integer.parseInt(st.nextToken()); //가로길이
        K = Integer.parseInt(st.nextToken()); //스티커 개수

        notebook = new int[N][M];

        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //스티커 세로 길이
            int m = Integer.parseInt(st.nextToken()); //스티커 가로 길이

            int[][] sticker = new int[n][m];

            for(int j = 0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<m; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if(!attach(sticker)){ //스티커 붙일 수 없으면
                for(int r = 0; r<3; r++){ //90도씩 회전
                    sticker = rotate(sticker);
                    if(attach(sticker)) break;
                }
            }
        }

        int result = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(notebook[i][j] == 1) result++;
            }
        }

        System.out.println(result);
    }

    static boolean attach(int[][] sticker){ //스티커 붙이기
        int n = sticker.length;
        int m = sticker[0].length;

        for (int x = 0; x <= N - n; x++) {
            for (int y = 0; y <= M - m; y++) {

                if (possible(sticker, x, y)) { //붙일 수 있으면 붙임
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (sticker[i][j] == 1) {
                                notebook[x + i][y + j] = 1;
                            }
                        }
                    }
                    return true;
                }

            }
        }
        return false;

    }

    static boolean possible(int[][] sticker, int x, int y){ //스티커 붙일 수 있는지 확인
        int n = sticker.length;
        int m = sticker[0].length;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(sticker[i][j] == 1 && notebook[x+i][y+j] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    static int[][] rotate(int[][] sticker){ //스티커 회전
        int n = sticker.length;
        int m = sticker[0].length;

        int[][] tmp = new int[m][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                tmp[j][n-1-i] = sticker[i][j];
            }
        }
        return tmp;
    }
}