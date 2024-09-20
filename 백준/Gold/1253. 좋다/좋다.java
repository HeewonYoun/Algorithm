import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int result = 0;

        //어떤 수가 다른 수 두개의 합으로 나타낼 수 있는지
        for(int i = 0; i<N; i++){
            int left = 0;
            int right = N-1;

            while(true){
                if(i == left) left++;
                else if(right == i) right--;

                if(left >= right) break; //끝

                if(num[left] + num[right] > num[i]) right--; //크면 왼쪽으로 이동
                else if(num[left] + num[right] < num[i]) left++; //작으면 오른쪽으로 이동
                else{ //같은 경우
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}