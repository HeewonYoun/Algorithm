import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[A];
        for(int i = 0; i<A; i++){
            result[i] = 1;
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j] && result[i] < result[j] + 1){
                    result[i] = result[j] + 1;
                }
            }
        }

        Arrays.sort(result);
        System.out.println(result[A-1]);

    }
}