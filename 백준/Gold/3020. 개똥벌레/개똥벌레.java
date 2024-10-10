import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //동굴의 길이
        H = Integer.parseInt(st.nextToken()); //동굴의 높이

        int[] bottom = new int[H+1];
        int[] top = new int[H+1];

        for(int i = 0; i<N; i+=2){
            int height = Integer.parseInt(br.readLine());
            bottom[height]++;

            height = Integer.parseInt(br.readLine());
            top[height]++;
        }

        //누적합 계산
        for(int i = H-1; i>0; i--){
            bottom[i] += bottom[i+1];
            top[i] += top[i+1];
        }

        int result = N;
        int count = 0;
        for(int i = 1; i<=H; i++){
            int tmp = bottom[H-i+1] + top[i];

            if(tmp < result){
                result = tmp;
                count = 1;
            } else if(tmp == result) count++;
        }

        System.out.println(result + " " + count);
    }
}