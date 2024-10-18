import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //물웅덩이 개수
        int L = Integer.parseInt(st.nextToken()); //널빤지 길이

        int[][] map = new int[N][2];

        for(int i = 0; i<N; i++){ //웅덩이 정보
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){ //시작점 같으면
                    return Integer.compare(o1[1], o2[1]); //끝 기준
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int result = 0;
        int last = 0;

        for(int i = 0; i<N ;i++){
            if(map[i][0] > last){ //시작위치가 범위보다 클 경우
                last = map[i][0];
            }
            if(map[i][1] >= last){ //끝 위치가 범위보다 큰 경우
                while(map[i][1] > last){
                    last += L;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}