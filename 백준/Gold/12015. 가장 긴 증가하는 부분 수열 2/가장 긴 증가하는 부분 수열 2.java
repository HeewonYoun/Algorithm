import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A]; // 1 <= A <= 1000000

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //binarySearch
        int[] result = new int[A];
        result[0] = arr[0];
        int length = 1;

        for(int i = 1; i<A; i++){
            int key = arr[i];

            if(result[length - 1] < key){
                length++;
                result[length -1] = key;
            } else {
                int lo = 0;
                int hi = length;
                while(lo < hi){
                    int mid = (lo + hi) / 2;
                    if(result[mid] < key){
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                result[lo] = key;
            }
        }
        System.out.println(length);
    }
}