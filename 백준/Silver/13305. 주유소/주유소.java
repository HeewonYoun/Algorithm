import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int minPrice = 1000000001;
        int totalLength = 0;

        N = Integer.parseInt(br.readLine()); //도시 개수
        int[] length = new int[N];
        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N-1; i++){ //도로 길이
            length[i] = Integer.parseInt(st.nextToken());
            totalLength += length[i];
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){ //가격
            cost[i] = Integer.parseInt(st.nextToken());
            if(cost[i] < minPrice) minPrice = cost[i];
        }

        long result = 0;
        int minCost = cost[0];

        for(int i = 0; i<N-1; i++){
            if(cost[i] < minCost){
                minCost = cost[i];
            }
            result += minCost * length[i];
        }

        System.out.println(result);
    }
}