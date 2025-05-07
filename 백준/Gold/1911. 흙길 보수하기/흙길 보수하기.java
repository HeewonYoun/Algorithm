import java.io.*;
import java.util.*;

public class Main {

    static int N, L;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //물웅덩이
        L = Integer.parseInt(st.nextToken()); //널빤지 길이

        map = new int[N][2];

        for(int i = 0; i<N; i++){ //웅덩이 정보
            st = new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken()); //시작위치
            map[i][1] = Integer.parseInt(st.nextToken()); //끝위치
        }

        Arrays.sort(map, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){ //시작위치 같으면
                    return Integer.compare(o1[1], o2[1]); //끝 기준
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int last = 0; //널빤지 덮은 마지막 위치

        for(int i = 0; i<N ;i++){
            if(map[i][0] > last){
                last = map[i][0]; //다시 널빤지 깔기
            }

            if(map[i][1] > last){
                while(map[i][1] > last){
                    last += L;
                    result++;
                }
            }
        }

        //널빤지 최소 개수
        System.out.println(result);
    }
}
