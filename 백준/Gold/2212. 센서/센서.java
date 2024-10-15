import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine()); //집중국 개수
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N <= K) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr); //센서 정렬
        int[] diff = new int[N-1];
        for(int i = 0; i<N-1; i++){
            diff[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(diff); //센서 간 거리 차이 정렬
        int result = 0;
        for(int i = 0; i<N-K; i++){ // (N-1)-(K-1)
            result += diff[i];
        }

        System.out.println(result);
    }
}