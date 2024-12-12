import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Integer[] limit;
    static List<Integer> box = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //크레인 개수
        limit = new Integer[N]; //무게제한

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            limit[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine()); //박스 수

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        //내림차순 정렬
        Arrays.sort(limit, Collections.reverseOrder());
        Collections.sort(box,Collections.reverseOrder());

        if(limit[0] < box.get(0)){ //못옮기는 경우
            System.out.println(-1);
            return;
        }

        int result = 0;

        while(!box.isEmpty()){
            int idx = 0; //박스 인덱스

            for(int i = 0; i<N;){
                if(idx == box.size()) break; //

                if(limit[i] >= box.get(idx)){
                    box.remove(idx);
                    i++;

                } else { //큰 경우
                    idx++;
                }
            }

            result++;
        }

        System.out.println(result);
    }
}