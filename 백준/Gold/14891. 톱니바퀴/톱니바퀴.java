import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] check = new int[4]; //돌릴지 말지 여부 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Character>[] gear = new ArrayList[4];
        for(int i = 0; i<4; i++){
            gear[i] = new ArrayList<>();
        }

        for(int i = 0; i<4; i++){
            char[] tmp = br.readLine().toCharArray(); //N극:0, S극:1
            for(int j = 0; j<8; j++){
                gear[i].add(tmp[j]);
            }
        }

        int K = Integer.parseInt(br.readLine()); //회전 횟수 (1<=K<=100)
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) -1; //톱니바퀴 번호
            int d = Integer.parseInt(st.nextToken()); //1:시계방향, -1:반시계방향

            check[num] = d;
            //톱니 돌릴지 여부 체크
            if(num == 0){
                for(int j = num+1; j<=3; j++){
                    //2번 인덱스 톱니와 다음 톱니의 6번 인덱스 톱니 비교
                    if(gear[j-1].get(2) == gear[j].get(6)){ //같은 극이면
                        break;
                    } else { //다른 극이면
                        check[j] = -(check[j-1]);
                    }
                }
            } else if(num == 3){
                for(int j = num-1; j>=0; j--){
                    //6번 인덱스 톱니와 이전 톱니의 2번 인덱스 톱니 비교
                    if(gear[j+1].get(6) == gear[j].get(2)){ //같은 극이면
                        break;
                    } else { //다른 극이면
                        check[j] = -(check[j+1]);
                    }
                }
            } else if(num == 1) { // 2번 톱니일 경우
                //1번 톱니 확인
                if(gear[num].get(6) != gear[0].get(2)){
                    check[0] = -(check[num]);
                }
                //3,4번 톱니 확인
                for(int j = 2; j<=3; j++){
                    if(gear[j-1].get(2) == gear[j].get(6)){
                        break;
                    } else {
                        check[j] = -(check[j-1]);
                    }
                }
            } else { // 3번 톱니일 경우
                //4번 톱니 확인
                if(gear[num].get(2) != gear[3].get(6)){
                    check[3] = -(check[num]);
                }
                //1,2번 톱니 확인
                for(int j = 1; j>=0; j--){
                    if(gear[j+1].get(6) == gear[j].get(2)){
                        break;
                    } else {
                        check[j] = -(check[j+1]);
                    }
                }
            }

            //톱니 돌리기
            for(int j = 0; j<4; j++){
                if(check[j] == 1){ //시계방향
                    //마지막 원소를 제일 앞으로
                    char tmp = gear[j].get(gear[j].size()-1);
                    gear[j].remove(gear[j].size()-1);
                    gear[j].add(0, tmp);

                } else if (check[j] == -1){ //반시계방향
                    //처음 원소를 마지막으로
                    char tmp = gear[j].get(0);
                    gear[j].remove(0);
                    gear[j].add(tmp);
                }
            }


            //여부 배열 초기화
            Arrays.fill(check, 0); // 0: 안돌림, 1: 시계방향, -1: 반시계방향
        }

        //점수 계산
        int result = 0;
        for(int i = 0; i<4; i++){ //N극:0, S극:1
            result += (gear[i].get(0)-'0') * Math.pow(2,i);
        }

        System.out.println(result);
    }
}