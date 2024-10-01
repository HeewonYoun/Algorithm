import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] gem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //아이들 수
        M = Integer.parseInt(st.nextToken()); //색상 수
        gem = new int[M];

        int left = 1;
        int right = 0;

        for(int i = 0; i<M; i++){
            gem[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, gem[i]);
        }

        int mid = 0;
        int sum = 0;
        int result = 0;

        while(left <= right){
            mid = (left + right)/2;
            sum = 0;

            for(int i = 0; i<M; i++){
                if(gem[i] % mid == 0){
                    sum += gem[i] / mid;
                } else {
                    sum += gem[i] / mid + 1;
                }
            }
            
            if(sum > N){ //보석 나눠줄 수 없는 경우
                left = mid + 1;
            } else { //보석 나눠줄 수 있는 경우
                right = mid -1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}