import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] job = new int[N][2];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            job[i][0] = Integer.parseInt(st.nextToken()); //걸리는 시간
            job[i][1] = Integer.parseInt(st.nextToken()); //끝내야 하는 시간
        }

        Arrays.sort(job, new Comparator<int[]>() { //끝내는 시간 기준으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        //일을 끝마칠 수 있는 가장 늦은 시간
        int result = job[0][1];
        for(int i = 0; i<N; i++){
            if(job[i][1] < result){
                result = job[i][1]; //끝내야 하는 시간
            }
            result -= job[i][0];
        }

        if(result < 0){
            System.out.println(-1);
        } else System.out.println(result);
    }
}