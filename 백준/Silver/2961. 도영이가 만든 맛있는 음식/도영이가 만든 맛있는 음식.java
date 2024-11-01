import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<int[]> taste = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //재료의 개수
        select = new boolean[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); //신맛
            int B = Integer.parseInt(st.nextToken()); //쓴맛

            taste.add(new int[]{S, B});
        }

        if(N == 1){ //재료 하나인 경우
            System.out.println(Math.abs(taste.get(0)[0] - taste.get(0)[1]));
            return;
        }

        //신맛: * , 쓴맛: +
        //신맛, 쓴맛 차이 작게, 재료 적어도 하나 사용

        for(int i = 1; i<=N; i++){
            dfs(0, 0, i);
        }

        System.out.println(result);
    }

    static void dfs(int cur, int count, int total){
        if(count == total){
            //차이 계산
            int sum = 0;
            int totalS = 1;
            int totalB = 0;
            for(int i = 0; i<select.length; i++){
                if(select[i]){
                    totalS *= taste.get(i)[0];
                    totalB += taste.get(i)[1];
                }
            }

            sum = Math.abs(totalS - totalB);
            if(sum < result) result = sum;
            return;
        }

        for(int i = cur; i<taste.size(); i++){
            if(select[i]) continue;

            select[i] = true;
            dfs(i+1, count+1, total);

            select[i] = false;
        }
    }
}