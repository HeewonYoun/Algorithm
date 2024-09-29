import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //사람 수
        M = Integer.parseInt(st.nextToken()); //파티 수

        //진실 아는 사람 수 (0~50), 번호
        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        boolean[] knowList = new boolean[N+1]; //진실 아는 사람들 리스트
        if(cnt > 0) {
            for(int i = 0; i<cnt; i++){
                knowList[Integer.parseInt(st.nextToken())] = true;
            }
        } else { //진실 아는 사람 0명일 경우
            System.out.println(M);
            return;
        }

        //각 파티마다 오는 사람 수 (1~50) , 번호들
        result = M;
        ArrayList<Integer>[] partyList = new ArrayList[M + 1];
        boolean[] partyVisited = new boolean[M+1]; //영향 받았는지

        for(int i = 1; i<M+1; i++){
            partyList[i] = new ArrayList<>();
        }

        for(int i = 1; i<M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                partyList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        //파티 탐색
        boolean updated = true;
        while(updated){
            updated = false;

            for(int i = 1; i<M+1; i++){
                if(partyVisited[i]) continue;

                boolean know = false;
                for(int person: partyList[i]) {
                    if(knowList[person]){ //진실 아는 사람 있으면
                        know = true;
                        break;
                    }
                }

                if(know){
                    for(int person: partyList[i]) {
                        if(!knowList[person]){
                            knowList[person] = true;
                            updated = true; // 진실 아는 사람 업데이트 됐으면
                        }
                    }
                    partyVisited[i] = true;
                    result--;
                }
            }
        }
        
        System.out.println(result);
    }
}