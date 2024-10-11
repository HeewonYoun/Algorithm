import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //집의 개수
        C = Integer.parseInt(st.nextToken()); //공유기 개수

        house = new int[N];
        for(int i = 0; i<N; i++){
            house[i] = Integer.parseInt(br.readLine()); //집 좌표
        }

        //이분탐색
        Arrays.sort(house); //정렬

        int low = 1;
        int high = house[N-1] - house[0] + 1;
        int mid = 0;

        while(low < high){
            mid = (low + high) / 2;

            if(canInstall(mid) < C) { // 설치 가능한 공유기 개수가 C보다 작으면
                high = mid; //거리 좁힘
            } else {
                low = mid + 1; //거리 늘림
            }
        }

        System.out.println(low-1);
    }

    static int canInstall(int dist){
        int count = 1; //첫번째 집 설치
        int lastLocate = house[0];

        for(int i = 1; i<N; i++){
            int locate = house[i];

            if(locate - lastLocate >= dist){
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}