import java.io.*;
import java.util.*;

public class Main {

    static int N, M, L;
    static List<Integer> loc = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //현재 휴게소 개수
        M = Integer.parseInt(st.nextToken()); //더 지으려고 하는 휴게소 개수
        L = Integer.parseInt(st.nextToken()); //고속도로 길이

        loc.add(0); //시작
        loc.add(L); //끝

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            loc.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(loc);

        int left = 1;
        int right = L;

        while(left <= right){
            int mid = (left + right) / 2; //간격
            int count = 0;

            for(int i = 1; i<loc.size(); i++){
                count += (loc.get(i) - loc.get(i-1) -1) / mid; //두 휴게소 사이에 mid 간격으로 휴게소를 몇 개 더 놓을 수 있는지
            }

            if(count > M) left = mid + 1; //간격 늘리기
            else right = mid - 1; //간격 줄이기
        }

        System.out.println(left);
    }
}