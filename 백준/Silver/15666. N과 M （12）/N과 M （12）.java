import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static TreeSet<Integer> num = new TreeSet<>();
    static List<Integer> nums;
    static int[] select;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        select = new int[M];

        //숫자 입력 받을 때 중복 방지
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            num.add(Integer.parseInt(st.nextToken()));
        }

        nums = new ArrayList(num);

        dfs(0, 0);
        System.out.println(sb);

    }

    //중복조합
    static void dfs(int count, int index){
        if(count == M){
            for(int i = 0; i<M; i++){
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = index; i<nums.size(); i++){
            select[count] = nums.get(i);
            dfs(count + 1, i);
        }
    }
}