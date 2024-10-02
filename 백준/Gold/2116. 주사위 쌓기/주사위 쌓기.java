import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dice = new int[N][6];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<6; j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        int result = 0;

        for(int i = 0; i<6; i++){
            int top = dice[0][i]; //첫번째 주사위의 각 면을 한번씩 선택
            int bottom = dice[0][check(i)];

            for(int j = 0; j<N; j++){ //주사위 차례대로 쌓기
                int max = 0;

                for(int k = 0; k<6; k++){
                    if(dice[j][k] == top){ //같은 숫자면
                        bottom = top; //갱신
                        top = dice[j][check(k)];

                        max = findMax(bottom, top);
                        break;
                    }
                }
                sum += max;
            }
            result = Math.max(result, sum);
            sum = 0;
        }
        System.out.println(result);
    }

    //0->5, 1->3, 2->4
    static int check(int n){
        if(n == 0) return 5;
        else if(n==1) return 3;
        else if(n==2) return 4;
        else if(n==3) return 1;
        else if(n==4) return 2;
        else return 0;
    }

    static int findMax(int bottom, int top){
        for(int i = 6; i>0; i--){ //6부터 가장 큰 값 return
            if(i != bottom && i != top){
                return i;
            }
        }
        return 0;
    }
}