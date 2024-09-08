import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static final int INF = 987654321;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 유저의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        arr = new int[N+1][N+1];

        for(int i = 1; i<= N; i++){
            for(int j = 1; j<=N; j++){
                arr[i][j] = INF; //초기값 설정

                if(i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());

            arr[tmp1][tmp2] = 1;
            arr[tmp2][tmp1] = 1;
        }

        //플로이드 워샬
        for(int k = 1; k<=N; k++){
            for(int i = 1; i<= N; i++){
                for(int j = 1; j<= N; j++){
                    if(arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int idx = -1;

        //케빈 베이컨의 수가 가장 작은 인덱스
        for(int i = 1; i<= N; i++){
            int total = 0;
            for(int j = 1; j<= N; j++){
                total += arr[i][j];
            }

            if(result > total){
                result = total;
                idx = i;
            }
        }

        System.out.println(idx);
    }
}