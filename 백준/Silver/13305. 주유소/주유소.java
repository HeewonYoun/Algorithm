import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine()); //도시 개수
        long [] length = new long[N-1];
        long [] cost = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N-1; i++){ //도로 길이
            length[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){ //가격
            cost[i] = Long.parseLong(st.nextToken());
        }

        long result = cost[0] * length[0]; //처음 주유소 이용
        long minCost = cost[0];

        for(int i = 1; i<N-1; i++){
            if(cost[i] < minCost){
                minCost = cost[i];
            }
            result += minCost * length[i];
        }

        System.out.println(result);
    }
}