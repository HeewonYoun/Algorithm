import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //원생 수
        int K = Integer.parseInt(st.nextToken()); //조의 개수

        int[] height = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        //티셔츠 비용 = 가장 키 큰 원생 - 가장 키 작은 원생
        //K개 조 티셔츠 만드는 비용의 합 최소
        int[] diff = new int[N-1];
        for(int i = 1; i<N; i++){
            diff[i-1] = height[i] - height[i-1];
        }

        //키 차이 오름차순 정렬
        Arrays.sort(diff);
        int result = 0;
        for(int i = 0; i<N-K; i++){
            result += diff[i];
        }

        System.out.println(result);
    }
}